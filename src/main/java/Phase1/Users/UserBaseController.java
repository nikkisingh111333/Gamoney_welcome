package Phase1.Users;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Phase1.Users.HibernateDataHandler;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.jvnet.staxex.Base64Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

//import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;

import Gamoneynew.Gamoneywelcomenew.Article;
//import com.sun.jersey.core.util.Base64;
@RequestScope //will create instance of this controller on every request to avoid any bug or problem
@RestController
@RefreshScope
public class UserBaseController {
	public UserBaseController(){
		System.out.println("I M USERBASE CONTROLLER");
		System.out.println("Created bean in:-"+new Date().toString());
	}
	 @Autowired
	  private RestHighLevelClient highLevelClient;

	  RestClient lowLevelClient = highLevelClient.getLowLevelClient();
	  
	private ModelAndView mv=new ModelAndView();
	@Autowired
	protected HibernateDataHandler hd;
	@Autowired
	protected EmailValidator E_valid;
	@Autowired
	protected Star_WalletOperations wo;
	@Autowired
	protected UserbaseRepo ur;
	@Autowired
	protected PasswordEncoder pe; 
	@Autowired
	private ElasticsearchRestTemplate ert;
	@GetMapping(value="/ESearch/{index}/{type}")
	public String getConn(@PathVariable("index") String index,@PathVariable("type") String type) {
        ert.indexOps(Article.class).create();
        ert.save(new Article("nikk","i m best code and ML enginner"));
        return "saved";
//
//
	}
	@GetMapping(value="/firstpage") //TO BE CONTINUED..
	public ModelAndView firstPage(HttpSession session) {
		String ref_name="";
		ModelAndView md=new ModelAndView("thymeleaf/FirstPage");
	      
      if(session.getAttribute("referID")!=null) {
	         ref_name=(String) com.lowagie.text.pdf.codec.Base64.decodeToObject((String) session.getAttribute("referID"));
	        
	            
      if(session.getAttribute("user")!=null) {
    		System.out.println("LOGGED IN");
    	  md.addObject("status",true);
      }
      else {
    	   	System.out.println("REFERED BY SOMEONE LOGIN FIRST");
    	      
    	  md.addObject("referID", ref_name);
    	  md.addObject("status",false);
       }
      return md;
      }
      else {
    	if(session.getAttribute("user")!=null) {
    		System.out.println("LOGIN COMPLETE");
    	  md.addObject("status",true);
          
    	  return md;
        }
    	else {
    		System.out.println("NOT LOGIN");
    		md.addObject("status",false);
            
      	  return md;
    	}
      }
      
	}
    @PostMapping(value="/save")
    public ModelAndView save(@ModelAttribute(name="user")user user,star_wallet uw,HttpServletResponse res,HttpServletRequest req){//(@RequestParam("user")String user,@RequestParam("pass")String pass,@RequestParam("email")String email,@RequestParam("number")String number) {
	   //......before everything we need to implements email validator and otp generator before register
	   
       
       String referID=req.getParameter("referID");
	   uw.setUsername(user.getUsername().trim());
	   System.out.println(user.getPassword()+"!!!!!!!!"+user.getUsername()+"!!!!!!"+user.getNationality()+"!!!!!"+user.getEmail());
	   String date=new Date().toString().trim();
	   uw.setAddedInAndAt(date);//Strip because postgres sucks sometime
	   String referbyname=null;
       if(referID!=null) {
    	    referbyname=(String) com.lowagie.text.pdf.codec.Base64.decodeToObject(referID);
       
	        uw.setTotalMoney(5);
       }
       else {

	        uw.setTotalMoney(3);
       }
	   user.setRoles("USER");
	   user.setPassword(pe.encode(user.getPassword()));
	   System.out.println("encoded pass:"+pe.encode(user.getPassword()));
	   try {
		  // user USER=new user(user,pass,email,number);
		   
        if(E_valid.validator(user.getEmail()).equals((String)"valid"))
        {  
	    //hd.SaveUser(user);//Add new user after validating it if username OR email is not registered OR If exist Will Throw exception and catch block willbe executed
	      ur.save(user);
          wo.CreateWalletORUpdate(uw);//WE WILL WORK ON IT
    	  res.sendRedirect("https://localhost:8998/apps/welcome/loginAccess");
	   // mv.setViewName("thymeleaf/Login"); 
	   // mv.addObject("now","Now you are set,LoggedIn to see whats waiting beyond the Wall");

   	      if(referbyname!=null) {
   	    	  star_wallet sv=wo.getStars(referbyname);
   	    	  Integer tot=sv.getTotalMoney();
   	    	 wo.updateStars(referbyname,tot+2 );
   	      }
          return mv; 
	   }
       else if(E_valid.validator(user.getEmail()).equals((String)"ServerProblems")) 
       {  //if any problems occur this will executed
    	  mv.addObject("error",E_valid.validator(user.getEmail())+"Wait or Try Again later we are looking for the problem!");
     	  mv.setViewName("thymeleaf/SignUp");
    	  return mv;
       }
       else if(E_valid.validator(user.getEmail()).equals((String)"invalid")) 
       {
    	  mv.addObject("error",E_valid.validator(user.getEmail())+"This is Invalid Email Please provide a valid email!");
    	  mv.setViewName("thymeleaf/SignUp");
    	  return mv;
       }
       else {//if nothing returns else will be executed!
    	  
    	  mv.setViewName("thymeleaf/SignUp");
    	  return mv;
       }
       
       
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   List l =hd.getUser();
		   
		   Iterator it=l.iterator();
		   while(it.hasNext()) {
			  user u=(Phase1.Users.user) it.next();
			  
			  System.out.println( u.getEmail()+"   "+u.getPassword()+"   "+u.getUsername());
			  if(user.getEmail().equals(u.getEmail())) 
			  {
				  mv.addObject("alreadyThere","Email is already Registered");
				  mv.setViewName("thymeleaf/SignUp");
				  return mv;
			  }
			  
			  
		  }
		  mv.addObject("UsernameExist","username exist Already choose another");
		  mv.setViewName("thymeleaf/SignUp");
		  return mv;
		   
	   }
   }
   @RequestMapping("/welcome")
   public ModelAndView giveit(HttpServletRequest req,HttpSession sess) {
	   String referID=req.getParameter("referID");

	   System.out.println(Thread.currentThread().getName());
	   ModelAndView mv=new ModelAndView();
	   mv.setViewName("thymeleaf/welcome");
	   if(referID!=null) {
	      mv.addObject("referID", referID);
	      sess.setAttribute("referID",referID);
	   }
	   return mv;
   }
//    @Value("${my.class}")
    String name;
   // @Value("${im.is.back}")
    String val;
   @GetMapping("/SIGNUP")
  // @Cacheable("signup")
   public ModelAndView redirectedSignup(HttpServletRequest req) {
	   String referID=req.getParameter("referID");
	    System.out.println(referID);
	    ModelAndView mv=new ModelAndView();
	    
	   if(referID!=null) {
		   mv.addObject("referID",referID);
	   }
	   System.out.println("Configs:"+name+"---"+val);
	   
	   mv.addObject("Welcome","welcome gamebud looking for some Competitions SignUp to our fucking Family");
	   mv.setViewName("thymeleaf/SignUp");
	   return mv;
   }
  // @Cacheable("loginpage")
   
   @GetMapping(value = {"/loginMe","/login"})   //multiple handler for google request and default page
   public ModelAndView login(HttpServletRequest req,HttpServletResponse res, String error, String logout) {
	   String ref_name=req.getParameter("referID");
	   ModelAndView mv=new ModelAndView();
	   if(ref_name!=null) {
		   
	   }
	   System.out.println("COMING HOME!"+logout+"______--"+error);
       if(error != null) 
       {
           mv.addObject("errorMsg", "Your username and password are invalid.");
           mv.setViewName("thymeleaf/loginform");
       }
       if(logout != null) 
       {
    	   SecurityContextLogoutHandler scl=new SecurityContextLogoutHandler();
    	   SecurityContext sc=(SecurityContext)req.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
    	   System.out.println("invalidating processing...!"+"__auth__"+sc.getAuthentication().getName());
    	   scl.logout(req, res,sc.getAuthentication() );
       	   mv.addObject("msg", "You have been logged out successfully.");
           mv.setViewName("thymeleaf/loginform");
       }
       mv.setViewName("thymeleaf/loginform");
       return mv;
   }
   @Autowired
   private Login login; //Login object use to fetch login credentials and verify logger
   
   @Cacheable("logins")  //we will fix this Cacheable later to make it work correctly
   @GetMapping(value="/loginAccess")
   public ModelAndView Login(HttpServletRequest req,HttpSession session) {
	   Enumeration c=req.getHeaderNames();
	   System.out.println("USER IP-ADDRESS"+req.getRemoteAddr()+"---other way------"+req.getHeader("X-FORWARDED-FOR"));
	   
   	   ModelAndView mv=new ModelAndView();
   	   System.out.println("loging :"+session.getId()+"----"+session.isNew()+"-----");
   	   System.out.println("its welome");
       SecurityContext sc=(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
	       
       //Name:[104678257807109404404], Granted Authorities: [[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash=3RyXwshQAYu-JK6IlTMs4g, sub=104678257807109404404, email_verified=true, iss=https://accounts.google.com, given_name=Nikki, locale=en-GB, picture=https://lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg, aud=[1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com], azp=1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com, name=Nikki Singh, exp=2020-04-30T09:18:41Z, family_name=Singh, iat=2020-04-30T08:18:41Z, email=nikkikkc04@gmail.com}]
       
   	       String principal=sc.getAuthentication().getPrincipal().toString();
   	       if(principal.contains("Principal")!=true) 
   	       {
              System.out.println(principal);
              String h=principal.split("User Attributes: ")[1].replace(":", "-").replace("/","^").replace(" ", "").trim();
              System.out.println(h);
		      Gson g=new Gson();
		      GoogleAuthData[] gd=g.fromJson(h,GoogleAuthData[].class );
		      System.out.println(gd[0].picture);
		      //System.out.println("name:"+gd[0].getGiven_name()+"--email--"+gd[0].getEmail()+"-------"+gd[0].getPicture().replace("^", "/").replace("-",":"));
		      String ref_name=null;
		      if(session.getAttribute("referID")!=null) {
		         ref_name=(String) com.lowagie.text.pdf.codec.Base64.decodeToObject((String) session.getAttribute("referID"));
              }
		      System.out.println("Ref_name:"+ref_name);
		      String pic_url=gd[0].getPicture().replace("^", "/");
		      StringBuilder sb=new StringBuilder(pic_url);
		      sb.replace(5, 6, ":");
		      Google_user g_user=new Google_user(gd[0].getGiven_name(),gd[0].getEmail(),"pending",sb.toString());
              System.out.println("nameee===="+gd[0].getGiven_name());
		      System.out.println("Real image:"+sb);
		      session.removeAttribute("phone");
		      session.setAttribute("picture", sb.toString());
		      Google_user g_u=(Google_user)hd.fetchOneUser(gd[0].getGiven_name(),Google_user.class);
		      if(g_u==null) {
		     	 System.out.println("SAVING GOOGLE USER");
		         hd.SaveUser(g_user);
		         star_wallet sw=new star_wallet();
		         if(ref_name!=null) 
		         {
                     star_wallet sw_new=new star_wallet();
		        	 sw_new.setAddedInAndAt(new Date().toString());
			         sw_new.setTotalMoney(5);
			         sw_new.setUsername(g_user.getUsername());
		        	 wo.CreateWalletORUpdate(sw_new);
		        	 sw=wo.getStars(ref_name);
		        	 wo.updateStars(ref_name, sw.getTotalMoney()+2);
		         }
		         else 
		         {
		        	 sw.setAddedInAndAt(new Date().toString());
			         sw.setTotalMoney(6);
			         sw.setUsername(g_user.getUsername());
		             wo.CreateWalletORUpdate(sw);
		         }
		    	  mv.addObject("phone","pending");
		    	  mv.addObject("login","yes");
		    	  mv.addObject("status",true);
		    	  mv.setViewName("thymeleaf/FirstPage");
				  return mv;
		      }
		      session.setAttribute("user", gd[0].getGiven_name());
		      System.out.println(session.getAttribute("user"));
			  mv.addObject("status",true);
		      mv.setViewName("thymeleaf/FirstPage");
		      return mv;
		   
   	       }
   	       else {
   	    	   System.out.println("WHAT THE FUCK HAPPNING HERE:"+sc.getAuthentication().getName());
   	    	   session.setAttribute("user",sc.getAuthentication().getName());
   	    	   mv.setViewName("thymeleaf/FirstPage");
   	    	   mv.addObject("status",true);
			   return mv;
   	       }
		   
	   
//	   else {
//	   mv.setViewName("thymeleaf/Login");
//	   mv.addObject("error","Wrong Credentials MayBe your PassWord Or UserName is wrong");
//	   return mv;
//	   }
   }
   @Cacheable("matchhub") //BY DEFAULT SPRING WILL USE THIS ANNO TO CREATE A HOT CACHE OBJECT TO MAKE APPLICATION FASTER BUT NEED EXTRA CONFIGURATION WITH REDIS CACHE 
   @RequestMapping("/TournamentHUB")
   public ModelAndView tournamentPage(HttpSession sess,HttpServletRequest req) {
   	   System.out.println("is it new session:"+sess.getAttribute("user")+"--"+sess.getServletContext().getSessionTimeout()+"=="+sess.getServletContext().getServerInfo()+"-header=="+req.getHeader("Cookie"));
   	   mv.setViewName("thymeleaf/TournamentHUB");
   	   return mv;
   }
   @GetMapping("/joined")
   public ModelAndView joined() {
	   ModelAndView mv=new ModelAndView("thymeleaf/Joined");
	   return mv;
   }
   @Autowired
   EmailSender es;
   @GetMapping("/Sendmail")
   public String m() throws IOException, URISyntaxException, MessagingException {
	  es.AttachmentFileMAil();;
	 // es.mailSend();
	   
	   return "mikki";
   }
   @GetMapping(value="/logmein",produces=MediaType.TEXT_PLAIN_VALUE)
   public String getUser(@RequestParam("user")String user) {
	   System.out.println("Called.......");
	   UserInterface u=hd.fetchOneUser(user,user.class);
	   Gson gson=new Gson();
	   String value=gson.toJson(u);
	   return value;
   }
   //FACEBOOK , GOOGLE , TWITTER LOGIN
   @PostMapping(value="/PhoneNumberUpdate")
   public ModelAndView getGoogleUser(HttpSession session,@RequestParam("phone")String phone){
	   System.out.println("Update Open");
	   ModelAndView mv=new ModelAndView("thymeleaf/FirstPage");
	   if(hd.fetchOneUser((String)session.getAttribute("user"),Google_user.class)==null) {
		   mv=new ModelAndView("thymeleaf/loginform");
		   return mv;
	   }
	   else {
		   Google_user g=new Google_user();
		   g.setPhone(phone);
		   int x=hd.updateUserInfo(Google_user.class, phone,(String)session.getAttribute("user"));
		   
		   System.out.println("UPDATEDDDD--"+x);
		   return mv;
	   }
   }
   
}
