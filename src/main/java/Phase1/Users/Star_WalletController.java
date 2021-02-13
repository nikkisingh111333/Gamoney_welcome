package Phase1.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Phase1.Users.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.RequestContext;
@RequestScope //will create new bean every time the request hit on this controller
@RestController
//@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST},
//allowCredentials ="true", 
//maxAge = 3 * 90,origins = "*") //ENABLING CORS REQUEST FOR OPTION PREFLIGHT REQUEST SENT BY BROWSER USING AJAX
public class Star_WalletController {
   @Autowired
   protected Star_WalletOperations wo;
   @GetMapping(value="/HowMuchStarsLeft",produces=MediaType.APPLICATION_JSON_VALUE)
   public star_wallet howmuch(HttpSession session,HttpServletRequest req) {
	 //  res.setHeader("Access-Control-Allow-Origin", "*"); //need to be set if we call a AJAX REQUEST for cross origin services .or simply we can say outside the origin server where the AJAX is defined
	   System.out.println("God session="+session.getId()+"..name.."+session.getAttribute("user")+"----");
	   
	   boolean s=Boolean.parseBoolean((req.getParameter("starcount")));

	   System.out.println("Its good :"+s);
	   if(s!=true) {
		 star_wallet sw=wo.getStars((String) session.getAttribute("user"));
	     if(sw!=null) {
	    	 int howMuch=sw.getTotalMoney();
	    	 if(howMuch>0) {
		        wo.updateStars((String) session.getAttribute("user"), howMuch-1);
		        
		        return sw;
	    	 }
	    	 return sw;
	   
	     }
	   }
	   else {
		   star_wallet sw=wo.getStars((String) session.getAttribute("user"));
		   return sw;
	   }
	    //EXPERIMENTS TO BE CONTINUED
	return null;
	   
   }
   @Cacheable("wallet")
   @RequestMapping(value = "/Wallet",produces=MediaType.APPLICATION_JSON_VALUE)
   public star_wallet method(HttpSession session) {
   	   System.out.println(session.getId()+"---WALLET---"+session.isNew());
   	star_wallet sw=wo.getStars((String)session.getAttribute("user"));
   	System.out.println(sw);
   	  return sw;
   }
}
