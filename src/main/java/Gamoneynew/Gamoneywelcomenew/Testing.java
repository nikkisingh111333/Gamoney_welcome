package Gamoneynew.Gamoneywelcomenew;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.InvocationTargetException;
//import java.net.URISyntaxException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.security.Principal;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.locks.ReentrantLock;
//
//import javax.imageio.ImageIO;
//
//import org.apache.commons.lang.ArrayUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.http.MediaType;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
//
//import com.google.gson.Gson;
//
//import reactor.core.publisher.Flux;
//
//
////import sun.net.www.protocol.http.HttpURLConnection;
//class Result{
// private ParsedResult[] ParsedResults;
//
//public ParsedResult[] getParsedResult() {
//	return ParsedResults;
//}
//
//public void setParsedResult(ParsedResult[] parsedResult) {
//	ParsedResults = parsedResult;
//}
//
//
//}
//class ParsedResult{
////	private DataX l;
////
////	public DataX getL() {
////		return l;
////	}
////
////	public void setL(DataX l) {
////		this.l = l;
////	}
//	private String ParsedText;
//	private TextOverlay TextOverlay;
//	public String getParsedText() {
//		return ParsedText;
//	}
//
//	public void setParsedText(String parsedText) {
//		this.ParsedText = parsedText;
//	}
//
//	public TextOverlay getTextOverlay() {
//		return TextOverlay;
//	}
//
//	public void setTextOverlay(TextOverlay textOverlay) {
//		TextOverlay = textOverlay;
//	}
//	
//}
//class TextOverlay{
//    Lines[] Lines;
//
//	public Lines[] getLines() {
//		return Lines;
//	}
//
//	public void setLines(Lines[] lines) {
//		Lines = lines;
//	}
//	
//}
//class Lines{
//	String LineText;
//
//	public String getLineText() {
//		return LineText;
//	}
//
//	public void setLineText(String lineText) {
//		LineText = lineText;
//	}
//	
//}
//class Match{
//	String name;
//	List lo;
//	
//	public String getName() throws Exception {
//		
//		return name;
//		
//	}
//	public List getLo() {
//		return this.lo;
//	}
//}
//@RestController
//public class Testing {
//	//@Autowired
//	//private HibernateDataHandler hd;
////	public static void premain(String h,Instrumentation u) {
////    	System.out.println("Agent of S.H.E.I.L.D.S");
////    }
////	public static void agentmain(String ar,Instrumentation i) {
////		System.out.println("gooood");
////	}
//  @Autowired
//  private RestTemplate rt;
////  public static void main (String[] hhj) throws IOException{
////	  //vivo img bluergb=rgb(56, 71, 137) r,g,b
////	  //iphone img bluergb=	rgb(66, 77, 140)
////	  //zenfone img bluergb=	rgb(48, 72, 156)
////	  //oppo img bluergb=	rgb(73, 96, 181)
////	  System.out.println("Starting....");
////	  BufferedImage bf=new BufferedImage(600,300,BufferedImage.TYPE_INT_ARGB);
////	  BufferedImage i=ImageIO.read(new File("C:\\Users\\Nikki singh\\Downloads\\Screenshot (22).png")); 
////	   
////	 // BufferedImage o=i.getSubimage(0, 36, 350, 120);
////      BufferedImage k=ImageIO.read(new File("C:\\Users\\Nikki singh\\Downloads\\Full-result.jpg"));  
////      
////      int width=i.getWidth();
////      int height = i.getHeight(); 
////      BufferedImage cropforRGB=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
////      
////      System.out.println("Original old="+i.getHeight()+"------"+i.getWidth());
////      //System.out.println(width+"----"+height);
////      //convert to greyscale 
////      int cw=cropforRGB.getWidth();
////      int ch=cropforRGB.getHeight();
////      int p=0;
////      int x=0;
////      for(int y = 1; y <ch ; y++) 
////      { 
////    	  
////          for( x = 1; x < cw; x++) 
////          {
//////               Here (x,y)denotes the coordinate of image  
//////               for modifying the pixel value.
////        	  Integer rgb=cropforRGB.getRGB(x,y);
////              int red = new Color(rgb).getRed(); 
////              int green = new Color(rgb).getGreen(); 
////              int blue = new Color(rgb).getBlue(); 
////              int alpha=new Color(rgb).getAlpha();
////                            
////              red=255-red;
////              green=255-green;
////              blue=255-blue;
////              int avg=(red+green+blue)/3;
////              
////               //  System.out.println(red+"----"+green+"----"+blue+"-AVG--"+avg);
////               //  System.out.println("Position: X-"+x+"---Y-"+y);
////                 p = (alpha<<24) | (red<<16) | (green<<8) | blue;
////                 cropforRGB.setRGB(x, y, p); //x=x axis ,y=y axis,p=changed rgb 
////          }
////      }
////      
////	 ByteArrayOutputStream os=new ByteArrayOutputStream();//will act as a container and store the stream into this object
////	 ImageIO.write(cropforRGB,"png",new File("C:\\Users\\Nikki singh\\Downloads\\MY-EXPeriment.png"));
////     BufferedImage ex=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
////     int cropX=0;
////     int cropY=0;
////        
////      for(int y = 1; y <ex.getHeight(); y++) 
////      { 
////          for( x = 1; x < ex.getWidth(); x++) 
////          {
////              Integer rgb_negativ=cropforRGB.getRGB(x,y);
////             int red = new Color(rgb_negativ).getRed(); 
////              int green = new Color(rgb_negativ).getGreen(); 
////             int blue = new Color(rgb_negativ).getBlue(); 
////               int alpha=new Color(rgb_negativ).getAlpha();
////                 
////               
////        	  if(blue<=175&&blue>=135&&red>=60&&red<=90&&green>=60&&green<=99) {
////        		System.out.println("Break");
////        		int pp=0;
////        		for(int y2 = 1; y2 <cropforRGB.getHeight(); y2++) 
////        	    { 
////        	         for( int x2 = 1; x2 < cropforRGB.getWidth(); x2++) 
////        	         {
////        	         	 Integer rgb_reverse=ex.getRGB(x2,y2);
////        	              int reverse_red = new Color(rgb_reverse).getRed(); 
////        	              int reverse_green = new Color(rgb_reverse).getGreen(); 
////        	              int reverse_blue = new Color(rgb_reverse).getBlue(); 
////        	               int reverse_alpha=new Color(rgb_reverse).getAlpha();
////        	               System.out.println("reverse:"+reverse_red+"--"+reverse_green+"--"+reverse_blue);  
////        	               
////        	               reverse_red=255-reverse_red;
////        	               reverse_green=255-reverse_green;
////        	               reverse_blue=255-reverse_blue;
////        	               
////        	               p = (alpha<<24) | (reverse_red<<16) | (reverse_green<<8) | reverse_blue;
////        	               cropforRGB.setRGB(x2, y2, p); 
////        	               
////        	         }
////        	    }
////        		ex=cropforRGB.getSubimage(30, y-7,235, 28);   
////        		System.out.println("Final pixel rgb:  Blue:"+blue+"--red:"+red+"--green:"+green);
////                cropX=x;
////                cropY=y;
////                break;
////        	  
////              }
////          
////              
////          } 
////             if(cropY==y&&cropX==x) {
////        	  System.out.println("CAlled");
////        	  break;
////             }
////          }
////          System.out.println("^^^^^^^^^^^^^^^^^^^^^^^TotalRGB:"+p);
////         
////
////           	  ByteArrayOutputStream os2=new ByteArrayOutputStream();//will act as a container and store the stream into this object
////           	 ImageIO.write(ex,"png",new File("C:\\Users\\Nikki singh\\Downloads\\Cropped-MY-EXPeriment.png"));
////           	 System.out.println("Ex size:"+ex.getHeight()+"----"+ex.getWidth());
////           	System.out.println("cropped size:"+cropforRGB.getHeight()+"----"+cropforRGB.getWidth());
////           	System.out.println("original image:"+i.getHeight()+"---"+i.getWidth());
////             //   var oo=ImageIO.read(new File("C:\\Users\\Nikki singh\\Downloads\\PUBG-Mobile-3.jpg")).getSubimage(60, 60,90, 90);
////                 
////              //   g.drawImage(ImageIO.read(new File("C:\\Users\\Nikki singh\\Downloads\\Image-Modified.png")), null,0,0);
////           // g.drawImage(oo, null,30,30);
////            Font f=new Font("bold",20, 20);
////            //    g.setFont(f);
////               //  g.drawString("HitmaN24", 30, 20);
////              
////                 //WRITE A NAME ON IMAGE 
////      // write image 
////   
////    	 // ImageIO.write(k,"png",os);//STORING IMAGE STREAM INTO BASE64 FORMAT and wraping into output stream
////    	  
////
////  
////	  //   System.out.println(ImageIO.write(i.getSubimage(0, 0, 50, 50), "png",new File("C:\\Users\\Nikki singh\\Downloads\\SVG-0cbc7331a77fc4021ff4d.png") ));
////		
////	  // attach to target VM
////
////      // get system properties in target VM
////
////      // construct path to management agent
////      
////
////      // load agent into target VM
////
////			   
////			  String password = "changeit";
////			  System.setProperty("javax.net.ssl.trustStore","C:/Program Files/Java/jdk-13.0.1/lib/security/cacerts".replace('/', File.separatorChar));
////			  System.setProperty("javax.net.ssl.trustStorePassword",password);
////	          String API_KEY = "d00a6f610cdc1cc7b5a6c1f183bf049e895b4906d737db5dad07a1cd5d53"; // Replace API_KEY with your API Key
////	     
////	    try {
////	      String EMAIL_ADDRESS = "nikkikkc04@gmail.com"; // Email address which need to be verified
////
////	      String urL = "http://api.quickemailverification.com/v1/verify?email="+EMAIL_ADDRESS+"&apikey="+API_KEY;
////	    	//RestTemplate res=new RestTemplate();
//////	      String host = "https://";
//////	      // int port = 9444;
//////	      String certificateName = "keystore";
//////	      String path = "C:/TrustStore/" + certificateName + ".p12";
//////	      char[] passphrase = "nikkibro0".toCharArray();
//////	      SSLSocketFactory sslFactory = null;
//////	 
//////	      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//////	      keyStore.load(new FileInputStream(path), passphrase);
//////	 
//////	      TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//////	      tmf.init(keyStore);
//////	      SSLContext ctx = SSLContext.getInstance("TLS");
//////	      ctx.init(null, tmf.getTrustManagers(), null);
//////	      sslFactory = ctx.getSocketFactory();
//////	 
////	      URL url = new URL("http://localhost:8008/test");
////	 
////	    //  CommonsHTTPTransportSender commonsHTTPTransportSender = new CommonsHTTPTransportSender();
//////	      commonsHTTPTransportSender.
//////	      HttpSOAPConnection soapConnection = new HttpSOAPConnection();
//////	      HttpSOAPConnection  connw = (HttpSOAPConnection ) url.openConnection();
////	
////	 
////	    }
//////	    catch (KeyStoreException e) {
//////	      // TODO Auto-generated catch block
//////	      e.printStackTrace();
//////	    }
//////	    catch (NoSuchAlgorithmException e) {
//////	      // TODO Auto-generated catch block
//////	      e.printStackTrace();
//////	    }
//////	    catch (CertificateException e) {
//////	      // TODO Auto-generated catch block
//////	      e.printStackTrace();
//////	    }
////	    
////	    catch (IOException e) {
////	      // TODO Auto-generated catch block
////	      e.printStackTrace();
////	    }
//////	    catch (KeyManagementException e) {
//////	      // TODO Auto-generated catch block
//////	      e.printStackTrace();
//////	    }
//////WebClient.builder().build().get().uri("http://localhost:8091/pm",Match.class).exchange().log().flatMapMany((client)->client.bodyToFlux(Match.class)).log().collectList();//reactive web
//////System.out.println(sb.toString());
//////for(Long m:v) {
//////System.out.println(m+"--"+Thread.getAllStackTraces());  //UNIQUE AND WELL DEFINED MECHANISM LOVE IT!
//////} 
////
////	
////
////  }
//	
//  //@HystrixCommand(fallbackMethod="fallback",threadPoolKey = "Hystrix" )
////  @GetMapping(value="/fetch/{name}")
////	public messages fetch(@PathVariable("name") String name,HttpServletRequest req,HttpSession sess) throws RestClientException, URISyntaxException {
////	     HttpHeaders h=new HttpHeaders();
////	     MultiValueMap mm=new LinkedMultiValueMap();
////	     
////	     System.out.println(sess.getId()+"----------");
////	     
////	     mm.add("Accept","application/json");
////	     mm.add("Cookie",sess.getId());
////	     HttpEntity<String> he= new HttpEntity("head",mm);
////	     
////		 return rt.exchange(new URI("https://localhost:8998/apps/welcome/redis/"+name),HttpMethod.GET,he,messages.class).getBody();
////		
////		
//////		for(Match b:v) {
//////			System.out.println("i m god"+b.name);
//////		}
////		
////	}
//    
//	public String fallback() {
//		return "not even there";
//	}
//	@Value("${my.name}")
//	String name;
//	@Value("${server.port}")
//	String port;
//	@GetMapping(value="/wee")
//	public ModelAndView welcome() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
////       System.out.println("new prperties:"+name+"__"+port);
////		boolean f= ResourceUtils.getFile("classpath:manifest.txt").exists();
////        System.out.println(f);
////        ByteBuddyAgent.install();
//    //    TypeDescription.ForLoadedType k=(ForLoadedType) TypeDescription.ForLoadedType.of(Match.class);
//		//FOR REDIFINING AN EXIXTIG CLASS AT RUNTIME AND MANUPLATE ITS CODE BY USING REDINED() OR REBIASED() METHODS OF BYTEBUDDY
//	//    TypePool typePool = TypePool.Default.ofSystemLoader();
////	    Object i= new ByteBuddy()
////	      .redefine(k, // do not use 'Bar.class'
////	                ClassFileLocator.ForClassLoader.ofSystemLoader())
////	      .defineField("qux", String.class) // we learn more about defining fields later
////	      .make()
////	      .load(ClassLoader.getSystemClassLoader()).getLoaded().getDeclaredConstructor().newInstance();
////	   System.out.println("new o:"+i);
//	   
//            		
//		//		 FOR CREATING A CLASS AT RUNTIME DYNAMICALLY AND USING IT WITH JSON PARSER WORKS GREAT EX 1
//
////        System.out.println(getClass().getClassLoader().getResources("Phase1.Users.Login.java").getClass());
////		DynamicType.Unloaded<?> r =  new ByteBuddy()
////				  .subclass(Object.class)				  
////				  .implement(RedisRepo.class)
////				  .name("Greatest")
////				  .defineField("name",String.class, Visibility.PUBLIC)
////				  .defineField("age",String.class, Visibility.PUBLIC)
////				  .defineMethod("getName",String.class, Visibility.PUBLIC)
////				  .intercept(FieldAccessor.ofBeanProperty())
////				  .defineMethod("getAge",String.class, Visibility.PUBLIC)
////				  .intercept(FieldAccessor.ofBeanProperty())
////				  .method(ElementMatchers.named("toString"))
////				  .intercept(FixedValue.value("good"))
////				  .make();//this will create a class dynamically 
////		r.saveIn(new File("C:\\Users\\Nikki singh\\workspace-sts-3.9.8.RELEASE\\Gamoney-welcome\\src\\main\\java\\Gamoney\\Great.java"));
////		r.inject(new File("C:\\Program Files\\Java\\jdk-13.0.1\\lib\\jrt-fs.jar"));
////		var k=r.load(getClass().getClassLoader(),ClassLoadingStrategy.Default.WRAPPER);//will take classloader for loading a class into our application at runtime
////		System.out.println("new runtime class:"+k.getLoaded().getMethods()[5].getName());
////	     StringBuilder sb=new StringBuilder();
////	     String d="{\r\n" + 
////					" \"name\":\"nikki\",\r\n" + 
////					" \"age\":\"900\"\r\n" + 
////					"}";
////			     System.out.println(d);
////			     Gson g=new Gson();
////			     RedisRepo t=(RedisRepo) g.fromJson(d,k.getLoaded());
////			     System.out.println(t.getAge());
//	      
//		//  FOR IMPLAMENTING AND CREATING INTERFACE LIKE JPAREPOSITORY AT RUNTIME EX 2
////		TypeDescription.ForPackageDescription genericType = TypeDescription.ForPackageDescription
////				   parameterizedType(JpaRepository.class,user.class , Long.class)
////				   .build();
////		AnnotationDescription entity = AnnotationDescription.Builder
////			    .ofType( Repository.class)
////			    .build();
////		DynamicType.Unloaded<?> dt = new ByteBuddy()
////				  .makeInterface(genericType)
////				  .name("Gamoney.PersonRepo")
////				  .annotateType(entity)
////				  .make();
////		dt.saveIn(new File("C:\\Users\\Nikki singh\\workspace-sts-3.9.8.RELEASE\\Gamoney-welcome\\target\\classes\\Phase1\\Users"));
////	      System.out.println("Is Loaded:"+ dt.load(getClass().getClassLoader(),ClassLoadingStrategy.Default.WRAPPER));     
//		
//		return new ModelAndView("thymeleaf/welcome");
//	}
//	//@Autowired
//	//RedisRepo rrepo;
////	@GetMapping(value="/redis/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
////	public messages hey(@PathVariable("name")String name,HttpServletRequest req,HttpSession sess) {
////		messages m=new messages();
////		m.setId(3);
////		m.age="30";
////		m.name=name;  
////	    System.out.println(req.getHeader("Cookie")+"------"+req.getSession().getId()+"-------"+req.getSession().getAttribute("user")+"-----"+req.getSession().isNew());
////		return m; 
////	}
//	@GetMapping(value="/JSsession")
//	public ModelAndView jsessionn() {
//		return new ModelAndView("jsp/Testing");
//	}
//	@GetMapping(value="/reinvoke",produces=MediaType.APPLICATION_JSON_VALUE)
//  public Flux<Lines> reinvoke() {
////    String API_KEY = "d00a6f610cdc1cc7b5a6c1f183bf049e895b4906d737db5dad07a1cd5d53"; // Replace API_KEY with your API Key
////    String EMAIL_ADDRESS = "nikkikkc04@gmail.com"; // Email address which need to be verified
////
////    String urL = "https://localhost:8871/redis/nikki";
////  	//RestTemplate res=new RestTemplate();
////    HttpHeaders header=new HttpHeaders();
////    header.add("Accept", "application/json");
////    
////   //var m=  rt.exchange(URI.create(urL),HttpMethod.GET, ,messages.class)getForObject(, );
//      List<Lines> l=new ArrayList<Lines>();
//		for(int y=0;y<89;y++) {
//			Lines p=new Lines();
//			p.setLineText("IM:"+y);
//    	  l.add(p);
//      }
//		return Flux.interval(Duration.ofSeconds(2)).fromIterable(l).log();
//  }
//	ReentrantLock rl=new ReentrantLock();
//	public Mat ArcadeNameFinder(Mat image,int org_width1,int org_width2) throws IOException{
//		System.out.println("Starting...NAme Finding .");
//		MatOfByte md=new MatOfByte(); 
//        Imgcodecs.imencode(".png", image,md);
//        ByteArrayInputStream inp=new ByteArrayInputStream(md.toArray());  //IN MEMORY INPUT STREAM OF ANY READABLE OBJECT STRING LIKE IMAGE,VIDEO,LARGE TEXT ETC.
//		  BufferedImage i=ImageIO.read(inp); 
//		  ByteArrayInputStream inp_2=new ByteArrayInputStream(md.toArray());
//		   BufferedImage org_cropped=ImageIO.read(inp_2);
//		 // BufferedImage o=i.getSubimage(0, 36, 350, 120);
//	      
//	      int width=i.getWidth();
//	      int height = i.getHeight(); 
//	      org_cropped=org_cropped.getSubimage((int)(width/3.2), (int)(height/3.5), (int)(width-(width/3.2)-210),(int)(height-(height/3.5)-150));
//
//          ImageIO.write(org_cropped,"png",new File("C:\\Users\\Nikki singh\\Downloads\\ORG_IMAGE_NAME.png"));
//	      BufferedImage cropforRGB=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
//	      System.out.println("Original old="+i.getHeight()+"------"+i.getWidth());
//	      //System.out.println(width+"----"+height);
//	      //convert to greyscale 
//	      int cw=cropforRGB.getWidth();
//	      int ch=cropforRGB.getHeight();
//	      int p=0;
//	      int x=0;
//	      //CONVERTING ORG IMG INTO NEGATIVE
//	      for(int y = 1; y <ch ; y++) 
//	      { 
//	          for( x = 1; x < cw; x++) 
//	          {
////	               Here (x,y)denotes the coordinate of image  
////	               for modifying the pixel value.
//	        	  Integer rgb=cropforRGB.getRGB(x,y);
//	              int red = new Color(rgb).getRed(); 
//	              int green = new Color(rgb).getGreen(); 
//	              int blue = new Color(rgb).getBlue(); 
//	              int alpha=new Color(rgb).getAlpha();
//	                            
//	              red=255-red;
//	              green=255-green;
//	              blue=255-blue;
//	              int avg=(red+green+blue)/3;
//	              
//	               //  System.out.println(red+"----"+green+"----"+blue+"-AVG--"+avg);
//	               //  System.out.println("Position: X-"+x+"---Y-"+y);
//	                 p = (alpha<<24) | (red<<16) | (green<<8) | blue;
//	                 cropforRGB.setRGB(x, y, p); //x=x axis ,y=y axis,p=changed rgb 
//	          }
//	      }
//	      
//		 //will act as a container and store the stream into this object
//		 ImageIO.write(cropforRGB,"png",new File("C:\\Users\\Nikki singh\\Downloads\\ARCADE_NAME_FINDED.png"));
//	     BufferedImage ex=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
//	     System.out.println("..height.."+ex.getHeight()+"---"+ex.getWidth());
//	     int cropX=0;
//	     int cropY=0;
//	        
//	     for(int y = 1; y <ex.getHeight(); y++) 
//	     { 
//	          for( x = 1; x < ex.getWidth(); x++) 
//	          {
//	              Integer rgb_negativ=cropforRGB.getRGB(x,y);
//	             int red = new Color(rgb_negativ).getRed(); 
//	              int green = new Color(rgb_negativ).getGreen(); 
//	             int blue = new Color(rgb_negativ).getBlue(); 
//	               int alpha=new Color(rgb_negativ).getAlpha();
//	                 
//	               
//	        	  if(blue<=210&&blue>=135&&red>=40&&red<=90&&green>=60&&green<=99) {
//	        		System.out.println("Break");
//	        		int pp=0;
//	        		for(int y2 = 1; y2 <cropforRGB.getHeight(); y2++) 
//	        	    { 
//	        	         for( int x2 = 1; x2 < cropforRGB.getWidth(); x2++) 
//	        	         {
//	        	         	 Integer rgb_reverse=ex.getRGB(x2,y2);
//	        	              int reverse_red = new Color(rgb_reverse).getRed(); 
//	        	              int reverse_green = new Color(rgb_reverse).getGreen(); 
//	        	              int reverse_blue = new Color(rgb_reverse).getBlue(); 
//	        	               int reverse_alpha=new Color(rgb_reverse).getAlpha();
//	        	             //  System.out.println("reverse:"+reverse_red+"--"+reverse_green+"--"+reverse_blue);    
//	        	               reverse_red=255-reverse_red;
//	        	               reverse_green=255-reverse_green;
//	        	               reverse_blue=255-reverse_blue;  
//	        	               p = (alpha<<24) | (reverse_red<<16) | (reverse_green<<8) | reverse_blue;
//	        	               cropforRGB.setRGB(x2, y2, p); 
//	        	         }
//	        	     }
//	        		 if(org_width1>1350&&org_width2>1350) {  //TO BE CONTINUED.....
//
//	        		     ex=org_cropped.getSubimage(10, y-10,195,60);  //only for arcade  
//	        		 }
//	        		 else {
//	        		     ex=cropforRGB.getSubimage(10, y-5,120,30); 
//	        		 }
//	        		  System.out.println("Final pixel rgb:  Blue:"+blue+"--red:"+red+"--green:"+green);
//	                  cropX=x;
//	                  cropY=y;
//	                  break;  
//	              }
//	          
//	              
//	          } 
//	             if(cropY==y&&cropX==x) {
//	        	  System.out.println("CAlled");
//	        	  break;
//	             }
//	          }
//	      ByteArrayOutputStream os=new ByteArrayOutputStream();//output stream in-memory holder
//	          ImageIO.write(ex,"png",os);
//	          ImageIO.write(ex,"png",new File("C:\\Users\\Nikki singh\\Downloads\\CROPPED_NAME.png"));
//	          Mat final_image=Imgcodecs.imdecode(new MatOfByte(os.toByteArray()),Imgcodecs.IMREAD_UNCHANGED);
//	          os.close();
//	          inp.close();
//	          return final_image;
//	        
//	}
//	public Mat matchDetailFinder(Mat image,int org_width1,int org_width2) throws IOException {
//		System.out.println("Starting....");
//		MatOfByte md=new MatOfByte(); 
//        Imgcodecs.imencode(".png", image,md);
//        ByteArrayInputStream inp=new ByteArrayInputStream(md.toArray());
//		  BufferedImage i=ImageIO.read(inp); 
//		   
//		 // BufferedImage o=i.getSubimage(0, 36, 350, 120);
//	      
//	      int width=i.getWidth();
//	      int height = i.getHeight(); 
//	      BufferedImage cropforRGB=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
//	      
//	      System.out.println("Original old="+i.getHeight()+"------"+i.getWidth());
//	      //System.out.println(width+"----"+height);
//	      //convert to greyscale 
//	      int cw=cropforRGB.getWidth();
//	      int ch=cropforRGB.getHeight();
//	      int p=0;
//	      int x=0;
//	      for(int y = 1; y <ch ; y++) 
//	      { 
//	          for( x = 1; x < cw; x++) 
//	          {
////	               Here (x,y)denotes the coordinate of image  
////	               for modifying the pixel value.
//	        	  Integer rgb=cropforRGB.getRGB(x,y);
//	              int red = new Color(rgb).getRed(); 
//	              int green = new Color(rgb).getGreen(); 
//	              int blue = new Color(rgb).getBlue(); 
//	              int alpha=new Color(rgb).getAlpha();
//	                            
//	              red=255-red;
//	              green=255-green;
//	              blue=255-blue;
//	              int avg=(red+green+blue)/3;
//	              
//	               //  System.out.println(red+"----"+green+"----"+blue+"-AVG--"+avg);
//	               //  System.out.println("Position: X-"+x+"---Y-"+y);
//	                 p = (alpha<<24) | (red<<16) | (green<<8) | blue;
//	                 cropforRGB.setRGB(x, y, p); //x=x axis ,y=y axis,p=changed rgb 
//	          }
//	      }
//	      
//		 //will act as a container and store the stream into this object
//		 ImageIO.write(cropforRGB,"png",new File("C:\\Users\\Nikki singh\\Downloads\\MY-EXPeriment.png"));
//	     BufferedImage ex=i.getSubimage((int)(width/2), (int)(height/3.5), (int)(width-(width/2)-210),(int)(height-(height/3.5)-150));
//	     
//	     int cropX=0;
//	     int cropY=0;
//	        
//	     for(int y = 1; y <ex.getHeight(); y++) 
//	     { 
//	          for( x = 1; x < ex.getWidth(); x++) 
//	          {
//	              Integer rgb_negativ=cropforRGB.getRGB(x,y);
//	             int red = new Color(rgb_negativ).getRed(); 
//	              int green = new Color(rgb_negativ).getGreen(); 
//	             int blue = new Color(rgb_negativ).getBlue(); 
//	               int alpha=new Color(rgb_negativ).getAlpha();
//	                 
//	               
//	        	  if(blue<=210&&blue>=135&&red>=40&&red<=90&&green>=60&&green<=99) {
//	        		System.out.println("Break");
//	        		int pp=0;
//	        		for(int y2 = 1; y2 <cropforRGB.getHeight(); y2++) 
//	        	    { 
//	        	         for( int x2 = 1; x2 < cropforRGB.getWidth(); x2++) 
//	        	         {
//	        	         	 Integer rgb_reverse=ex.getRGB(x2,y2);
//	        	              int reverse_red = new Color(rgb_reverse).getRed(); 
//	        	              int reverse_green = new Color(rgb_reverse).getGreen(); 
//	        	              int reverse_blue = new Color(rgb_reverse).getBlue(); 
//	        	               int reverse_alpha=new Color(rgb_reverse).getAlpha();
//	        	             //  System.out.println("reverse:"+reverse_red+"--"+reverse_green+"--"+reverse_blue);  
//	        	               
//	        	               reverse_red=255-reverse_red;
//	        	               reverse_green=255-reverse_green;
//	        	               reverse_blue=255-reverse_blue;
//	        	               
//	        	               p = (alpha<<24) | (reverse_red<<16) | (reverse_green<<8) | reverse_blue;
//	        	               cropforRGB.setRGB(x2, y2, p); 
//	        	               
//	        	         }
//	        	     }
//	        		if(org_width1>1350&&org_width2>1350) { 
//
//	        		     ex=cropforRGB.getSubimage(30, y-10,200,70); 
//	        		}
//	        		else {
//	        		     ex=cropforRGB.getSubimage(30, y-10,120,30); 
//	        		}
//	        		System.out.println("Final pixel rgb:  Blue:"+blue+"--red:"+red+"--green:"+green);
//	                cropX=x;
//	                cropY=y;
//	                break;  
//	              }
//	          
//	              
//	          } 
//	             if(cropY==y&&cropX==x) {
//	        	  System.out.println("CAlled");
//	        	  break;
//	             }
//	          }
//	      ByteArrayOutputStream os=new ByteArrayOutputStream();//output stream in-memory holder
//	          ImageIO.write(ex,"png",os);
//	          Mat final_image=Imgcodecs.imdecode(new MatOfByte(os.toByteArray()),Imgcodecs.IMREAD_UNCHANGED);
//	          os.close();
//	          inp.close();
//	          return final_image;
//	        
//	}
//  @PostMapping("/ImageTest")
//  public String imageReader(@RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException, InterruptedException {
//	
//	  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//	  StringBuilder line=new StringBuilder();
//           System.out.println(image1.getSize());
//		   StringBuilder sb=new StringBuilder();
//		   BufferedReader br=new BufferedReader(new InputStreamReader(image1.getInputStream()));  //result image
//		   StringBuilder sb2=new StringBuilder();
//		   BufferedReader br2=new BufferedReader(new InputStreamReader(image2.getInputStream()));  //identity image
//		//   BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f2)));  //identity image
//		   
//			while(br.read()!=-1) {
//				   sb.append(br.readLine());
//			}
//			while(br2.read()!=-1) {
//				   sb2.append(br.readLine());
//			}
//			byte[] l=image1.getBytes();//img 1
//			byte[] l2=image2.getBytes();//img 2
//			System.out.println("Byte 1:"+l[0]);
//			Imgcodecs imc=new Imgcodecs();  
//			//WIll decode inputstream image bytes image into matofbyte and then create MAt image from it for further opencv processesing
//			Mat img_1=imc.imdecode(new MatOfByte(l),imc.IMREAD_UNCHANGED);//image will remain unchanged experiment later on return Mat from this inputstream we got.
//		    Mat img_2=imc.imdecode(new MatOfByte(l2),imc.IMREAD_UNCHANGED);
//		    int org_img1_width=img_1.width();
//		    int org_img2_width=img_2.width();
//		 //   System.out.println(img_1.dump());
//		    System.out.println(img_1.channels()+"---channel--"+img_2.channels());
//		    Imgproc.cvtColor(img_1,img_1,Imgproc.COLOR_BGRA2BGR);  //will convert this image mat fron rgba to rgb ..4 channel to 3 channel image
//		    Imgproc.cvtColor(img_2,img_2,Imgproc.COLOR_BGRA2BGR);
//		    Mat croped_detail=null;
//		    int image_size1=(int) image1.getSize();                   
//		    int image_size2=(int) image2.getSize(); 
//		    
//		    System.out.println(image_size1+"-----------"+image_size2);
//		    System.out.println(img_1.rows()+"----------------"+img_2.cols());
//		    InputStream img1=new ByteArrayInputStream(l);
//		    InputStream img2=new ByteArrayInputStream(l2); //IN-MEMORY inputstream container
//		    BufferedImage bf1=ImageIO.read(img1);
//		    BufferedImage bf2=ImageIO.read(img2);
//		    System.out.println("Image1 size:---height-"+bf1.getHeight()+"Image1 size:---width-"+bf1.getWidth());
//		    System.out.println("Image2 size:---height-"+bf2.getHeight()+"Image2 size:---width-"+bf2.getWidth());
//		    //bf1.getSubimage(100, 100, w, h)
//		      int img1_width=bf1.getWidth();
//		      int img1_height = bf1.getHeight(); 
//		      int img2_width=bf2.getWidth();
//		      int img2_height=bf2.getHeight();
//		      BufferedImage cropforRGB_img1=bf1.getSubimage(0, 0, 100,7);
//                
//		      BufferedImage cropforRGB_img2=bf2.getSubimage(0, 0, 100,7);
//	           
//		      ImageIO.write(cropforRGB_img1,"png", new File("C:\\Users\\Nikki singh\\Downloads\\CroppedRGB_img1.png"));
//	           
//	          ImageIO.write(cropforRGB_img2,"png", new File("C:\\Users\\Nikki singh\\Downloads\\CroppedRGB_img2.png"));
//		      System.out.println("Img1 width:"+img1_width+"--Img1 height----"+img2_height);
//		      System.out.println("Img2 width:"+img2_width+"--Img2 height----"+img2_height);
//		      //System.out.println(width+"----"+height);
//		      //convert to greyscale 
//		      Long image1_rgb=0L;
//		      Long image2_rgb=0L;
//		      for(int y = 0; y < cropforRGB_img1.getHeight(); y++) 
//		      { 
//		          for(int x = 0; x < cropforRGB_img1.getWidth(); x++) 
//		          {
////		               Here (x,y)denotes the coordinate of image  
////		               for modifying the pixel value.
//		        	 Integer rgb= cropforRGB_img1.getRGB(x,y);
//		        	 
//		        	  if(rgb<0) {
//		        		//  System.out.println("img1-RealRgb:"+rgb);
//		        	       rgb=Math.abs(rgb);
//
////				        	  System.out.println("img1-RealRgb after abs:"+rgb);
//		        	  }
//		        	  else {
//		        		//  System.out.println("img1-RealRgb-2:"+rgb);
//		        	      
//		        		 rgb=rgb;
//
//		        	  }
//		        	  image1_rgb+=rgb;
//		              //Iphone rgd:187, 200, 209
//		        	  //Vivo rgb:171, 184, 193
//		          } 
//		      } 
//            
//	          System.out.println("^^^^^^^^^^^^^^^^^^^^^^^TotalRGB_img-1:"+ image1_rgb);
//		      for(int y = 0; y < cropforRGB_img2.getHeight(); y++) 
//		      { 
//		          for(int x = 0; x < cropforRGB_img2.getWidth(); x++) 
//		          {
////		               Here (x,y)denotes the coordinate of image  
////		               for modifying the pixel value.
//		        	  Integer rgb= cropforRGB_img2.getRGB(x,y);
//		        	  if(rgb<0) {
//		        	//  System.out.println("img2-RealRgb:"+rgb);
//		        	     rgb=Math.abs(rgb); //ABSOLUTE VALUE OF AN NUMBER
//		        	//  System.out.println("img2-RealRgb after abs:"+rgb);
//		        	  }
//		        	  else {
//		        		//  System.out.println("img2-RealRgb-2:"+rgb);
//		        		  rgb=rgb;
//		        	  }
//		              image2_rgb+=rgb;
//		           //   System.out.println("After adding :"+image2_rgb);
//		          } 
//		      } 
//		     
//            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^TotalRGB img-2:"+ image2_rgb);
//		      //MATH.abs(long l)  will turn any negative number or long integer into positive and return it
//            int height2=0;
//            int height=0;
//		  if(org_img1_width>1350&&org_img2_width>1350) {
//
//	           height=img_1.height()/2-250;
//	           height2=img_2.height()/10;
//		  }
//		  else if(org_img1_width<=1210&&org_img2_width<=1210){
//			  System.out.println("kyaaa h reee");
//               height=img_1.height()/2-120;
//               height2=img_2.height()/2-122;
//		  }
//		  else {
//			  System.out.println("good");
//			  height=img_1.height()/2-190;
//              height2=img_2.height()/2-120;
//		  }
//		  Mat name_finder=null;
//		  Mat name_filtered=new Mat();
//		  
//          if(image1_rgb<image2_rgb) 
//		  {
//		    System.out.println("its happening_"+img_1.width()/3.1);
////		//    	img_1=new Mat(img_1,new Rect(50,8,img_1.width()-810,img1_height-400)); //crop this image according to its rect providede and create a new mat from its pixel data
//		    if(org_img1_width>1350&&org_img2_width>1350) {
//
//			     img_1=new Mat(img_1,new Rect(112,8,(int) (img_1.width()/3.1),height));
//			     System.out.println(img_1.width());
//			     croped_detail=this.matchDetailFinder(img_2,org_img1_width,org_img2_width);
//			     name_finder=this.ArcadeNameFinder(img_2, org_img1_width, org_img2_width);  //ONLY FOR ARCADE
//			     img_2=new Mat(img_2,new Rect(78,15,img_2.width()-350,height2));
//		    }
//		    else {
//		    
//		         img_1=new Mat(img_1,new Rect(50,8,(int) (img_1.width()/3.1),height));
//		          System.out.println(img_1.width());
//		         croped_detail=this.matchDetailFinder(img_2,org_img1_width,org_img2_width);
//		          img_2=new Mat(img_2,new Rect(78,15,img_2.width()-350,58));
//		    }
//		     
//		  }
//		  else 
//		  {
////		     System.out.println("again happening_"+img_2.width()/3.1); 
////           img_2=new Mat(img_2,new Rect(50,8,img_2.width()-810,img2_height-400));
//		   if(org_img1_width>=1350&&org_img2_width>=1350) {
//			   System.out.println("Big Imag:"+org_img1_width+"-----"+org_img1_width);
//		      img_2=new Mat(img_2,new Rect(112,8,(int) (img_2.width()/3.1),height));
//		      System.out.println(img_2.width());
//		      croped_detail=this.matchDetailFinder(img_1,org_img1_width,org_img2_width);//Beast function for match stat finder
//		      img_1=new Mat(img_1,new Rect(78,15,img_1.width()-350,height2));
//		   }
//		   else {
//
//			      img_2=new Mat(img_2,new Rect(50,8,(int) (img_2.width()/3.1),height));
//			      System.out.println(img_2.width());
//			      croped_detail=this.matchDetailFinder(img_1,org_img1_width,org_img2_width);//Beast function for match stat finder
//			      img_1=new Mat(img_1,new Rect(78,15,img_1.width()-350,58)); //NAME HEIGHT
//		   }
//		     
//		  }
//		  Mat img_1_filtered=new Mat();
//		  Mat img_2_filtered=new Mat();
//		  Mat crop_holder=new Mat();
//		  if(image1_rgb<image2_rgb) {
//			  System.out.println("What");
//	          Imgproc.bilateralFilter(img_1,img_1_filtered, 30,30,30); //billateral will work only on original image before anybother filtering or dillation
//	        //Imgproc.dilate(img_1_filtered, img_1_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_1.width(),img_1.height())));
//	          Imgproc.GaussianBlur(img_1_filtered,img_1_filtered, new Size(9,9),9);//WILL BLUR ENTIRE IMAGE WITH 9,9 KERNEL WITH SIZE OF 9
//	          Core.addWeighted(img_1, 1.5, img_1_filtered,-0.5,0, img_1_filtered);//WILL WEIGHT THIS IMAGE FOLLOWING ALGO WORK BEHIND:[src*alpha+dst*beta+gamma]
//	          Imgproc.bilateralFilter(croped_detail,crop_holder, 30,30,30); //billateral will work only on original image before anybother filtering or dillation
//	        
//	        //ARCADE NAME FILTERING...
//             // Imgproc.bilateralFilter(name_finder,name_filtered, 30,30,30);
//  	        //Imgproc.dilate(img_2_filtered, img_2_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_2.width(),img_2.height())));
//  	 	   //   Imgproc.GaussianBlur(name_filtered,name_filtered, new Size(9,9),9);  //MAT SRC,MAT DST,SIZE OF KERNAL MATRIX,SIGMAX
//             //   Core.addWeighted(name_finder, 1.5, name_filtered,-0.5,0, name_filtered); //compare original image with blurred image and find the weighted mean of this image
//                
//	          
//	          //Imgproc.dilate(img_1_filtered, img_1_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_1.width(),img_1.height())));
//	          Imgproc.GaussianBlur(crop_holder,crop_holder, new Size(9,9),9);//WILL BLUR ENTIRE IMAGE WITH 9,9 KERNEL WITH SIZE OF 9
//	          Core.addWeighted(croped_detail, 1.5, crop_holder,-0.5,0,crop_holder);//WILL WEIGHT THIS IMAGE FOLLOWING ALGO WORK BEHIND:[src*alpha+dst*beta+gamma]
//	          img_2_filtered=img_2;
//	      }
//	      else 
//	      {
//	          Imgproc.bilateralFilter(img_2,img_2_filtered, 30,30,30);
//	        //Imgproc.dilate(img_2_filtered, img_2_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_2.width(),img_2.height())));
//	 	      Imgproc.GaussianBlur(img_2_filtered,img_2_filtered, new Size(9,9),9);  //MAT SRC,MAT DST,SIZE OF KERNAL MATRIX,SIGMAX
//              Core.addWeighted(img_2, 1.5, img_2_filtered,-0.5,0, img_2_filtered); 
//              
//              //ARCADE NAME FILTERING...
//        //      Imgproc.bilateralFilter(name_finder,name_filtered, 30,30,30);
//  	        //Imgproc.dilate(img_2_filtered, img_2_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_2.width(),img_2.height())));
//  	 	   //   Imgproc.GaussianBlur(name_filtered,name_filtered, new Size(9,9),9);  //MAT SRC,MAT DST,SIZE OF KERNAL MATRIX,SIGMAX
//            //    Core.addWeighted(name_finder, 1.5, name_filtered,-0.5,0, name_filtered); //compare original image with blurred image and find the weighted mean of this image
//                
//              
//              Imgproc.bilateralFilter(croped_detail,crop_holder, 30,30,30); //billateral will work only on original image before anybother filtering or dillation
//	        //Imgproc.dilate(img_1_filtered, img_1_filtered,Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(img_1.width(),img_1.height())));
//	          Imgproc.GaussianBlur(crop_holder,crop_holder, new Size(9,9),9);//WILL BLUR ENTIRE IMAGE WITH 9,9 KERNEL WITH SIZE OF 9
//	          Core.addWeighted(croped_detail, 1.5, crop_holder,-0.5,0,crop_holder);//WILL WEIGHT THIS IMAGE FOLLOWING ALGO WORK BEHIND:[src*alpha+dst*beta+gamma]
//	         
//		      img_1_filtered=img_1;
//	      }
//	      if(image1_rgb<image2_rgb) { //
//	        	//create Rectangle shape in the following area of image
//		          	Imgproc.rectangle(img_1_filtered, new Rect(0,0,img_1_filtered.width(),20), new Scalar(220,110,220),75);
//		        //Imgproc.rectangle(img_1_filtered, new Rect(0,img,img_1_filtered.width(),20), new Scalar(220,110,220),70);
//	      }
//	      else 
//	      {
//	            	Imgproc.rectangle(img_2_filtered, new Rect(0,0,img_2_filtered.width(),20), new Scalar(220,110,220),75);
//	      }           
//	           MatOfByte mm=new MatOfByte();
//	            MatOfByte m2=new MatOfByte();
//	            MatOfByte m3=new MatOfByte();
//	            MatOfByte m4=null;
//
//	             m4=new MatOfByte();
//			   
//	           imc.imencode(".png",img_1_filtered,mm); //encode the processed mat into matofbyte as byte mat 
//	             imc.imencode(".png",img_2_filtered,m2);
//	            imc.imencode(".png", crop_holder, m3);//encode the processed mat into matofbyte as byte mat
//
//	         //    imc.imencode(".png", name_filtered, m4);
//			   
//	           System.out.println("Matofbyte 1:"+mm.get(0, 0)[0]);
//	           byte[] b=mm.toArray();
//	            byte[] b2=m2.toArray();
//	             byte[] b3=m3.toArray();
//	             byte[] b4=null;
//
//	  //       b4 =m4.toArray();
//		 
//	           InputStream in=new ByteArrayInputStream(b); //IN-MEMORY INPUT STREAM FOR IMAGE HOLDER AS STREAM
//	            InputStream in2=new ByteArrayInputStream(b2);
//	             InputStream in3=new ByteArrayInputStream(b3);
//	           //  InputStream in4=null;
//
//	  //         in4=new ByteArrayInputStream(b4);
//	    
//	           BufferedImage buff_img1=ImageIO.read(in);
//	              BufferedImage buff_img2=ImageIO.read(in2);
//	           BufferedImage buff_img3=ImageIO.read(in3); // damage,survival
//	         //  BufferedImage buff_img4=null;
//	   if(org_img1_width>1350&&org_img2_width>1350) {
//	     	    	
//	     	    
//	           //  buff_img4=ImageIO.read(in4);
//	   }
//	       BufferedImage buff_big=null;
//	   if(org_img1_width>1350&&org_img2_width>1350) {
//	        	    buff_big=new BufferedImage(850,550,BufferedImage.TYPE_INT_ARGB);
//	   }
//	   else {
//      	    buff_big=new BufferedImage(500,350,BufferedImage.TYPE_INT_ARGB);
//	   }
//               Graphics g=buff_big.getGraphics();  //ADDING ALL IMAGE PIECES INTO ONE..
//	             g.setFont(new Font("bold",Font.PLAIN,40));
//	             g.setColor(new Color(150,100,50));
//	   if(image1_rgb<image2_rgb) {
//		   g.drawImage(buff_img1, 10,0,null);
//
//	       g.drawImage(buff_img2, 10,0,null);
//	          
//	        //      g.drawImage(buff_img4, 10,0,null);
//	       
//	       g.drawString("AND", 10, height+105);
//	       g.drawImage(buff_img3, 107,height+75,null);
//	   }
//	   else
//	   {
//	       g.drawImage(buff_img2, 10,0,null);
//	       g.drawImage(buff_img1, 10,0,null);
//	       g.drawString("AND", 10, height+105);
//           g.drawImage(buff_img3, 107,height+75,null);
//	   }
//	    ByteArrayOutputStream bout=new ByteArrayOutputStream();
//	           ImageIO.write(buff_big,"png", new File("C:\\Users\\Nikki singh\\Downloads\\LIveScreenshot.png"));
//		       ImageIO.write(buff_big,"png", bout);
//		       InputStream final_image=new ByteArrayInputStream(bout.toByteArray()); 
//		       HttpClient hcl=HttpClients.createDefault();
//		       HttpPost h=new HttpPost("http://api.ocr.space/parse/image");   
//     //FileBody fileBody = new FileBody(file, ContentType.IMAGE_PNG);
//		       ByteArrayInputStream bs=new ByteArrayInputStream(image1.getBytes());
//	           MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//	           builder.setMode(HttpMultipartMode.STRICT);
//     //Creating form body 
//	           builder.addBinaryBody("file", final_image,ContentType.IMAGE_PNG,image1.getOriginalFilename()); //IMAGE AS INPUT STREAM WITH ITS TYPE
//	           builder.addTextBody("language", "eng"); //LANGUAGE TO BE PARSED IN OCR
//	           builder.addTextBody("OCREngine", "2"); //OCRENGINE 1 OR 2
//	           builder.addTextBody("filetype","PNG"); //FILETYPE .PNG,.JPG .TIF ETC
//	           builder.addTextBody("scale","true"); //SCALE ZOOMING IMAGE
//	           builder.addTextBody("detectOrientation", "true"); //ORIENTATION OF IMAGE
//	           builder.addTextBody("isOverlayRequired", "true");
//	           h.addHeader("apikey","f30145498288957" ); //SECRET API KEY
//	           org.apache.http.HttpEntity hc= builder.build(); //GETTING HTTPENTITY OF THIS MUTLIPART BODY
//	           h.setEntity(hc);
//	           HttpResponse res= hcl.execute(h);
//	           String result= EntityUtils.toString(res.getEntity());
//	           System.out.println( result);//successfulll now its time to plan
//	           Gson gson=new Gson();
//	           Result re=gson.fromJson(result,Result.class);
//	           System.out.println(re.getParsedResult()[0].getTextOverlay().Lines[0].getLineText());
//	           System.out.println(re.getParsedResult()[0].getTextOverlay().Lines[5].getLineText());  
//	          Lines[] lins=re.getParsedResult()[0].getTextOverlay().Lines;
//	           for(int x=0;x<lins.length;x++) {
//	        	   System.out.println("All Lines:"+lins[x].getLineText());
//	        	   if(lins[x].getLineText()=="TOP10"||lins[x].getLineText().contains("TOPID")||lins[x].getLineText().contains("ID")) {
//	        		  System.out.println("Beztii:"+lins[x].getLineText());
//	        		   lins=(Lines[]) ArrayUtils.remove(lins,x);
//	        	   }
//	           }
//	  //  System.out.println(re.getParsedResult()[0].getTextOverlay().Lines[0].getLineText().toLowerCase().substring(0,"hitman24".length()));
//	           String name="hitman24";
//	           int level=1;
//	           String rem= lins[0].getLineText().toLowerCase();
//	           String date=lins[5].getLineText().toLowerCase();
//	           System.out.println("DAte length:"+date);
//	           if(date.contains("d")||date.contains("o")||date.contains("b")||date.contains("B")||date.contains("i")||date.contains("l")||date.contains("g")||date.contains("s")) {
//	                date=date.replace("d", "0").replace("o", "0").replace("b", "8").replace("i","1").replace("l","1").replace("s","5").replace("g", "6");
//	           }
//	           StringBuilder sb22=new StringBuilder(date);
//	           System.out.println(sb22);
//	           if(sb22.toString().contains(" ")||String.valueOf(date.charAt(5))==" ") 
//	    	   {
//    	    		System.out.println("date:"+sb22);
//	    	   }
//	    	   else 
//	    	   {
//	    	        date= sb22.insert(5," ").toString();
//	    		    System.out.println("date:"+sb22);
//	    	   }
//	           image1.getInputStream().close();
//	           image2.getInputStream().close();
//	           System.out.println(date);
//	           ConcurrentHashMap<String,List> map=new ConcurrentHashMap<String,List>();
//	           List<Boolean> chars=new ArrayList();
//	           List<Boolean> sequence=new ArrayList();
//	    //PHASE 1 CHAR finder
//	           for(int i=0;i<name.length();i++) 
//	           {
//	             try 
//	             {
//	               Boolean e=name.contains(String.valueOf(re.getParsedResult()[0].getTextOverlay().Lines[0].getLineText().toLowerCase().charAt(i))); 
//	                chars.add(e); 
//	                  System.out.println("Exist:"+e);
//	             } 
//	             catch(Exception ex) {
//	    	         System.out.println("Exception:"+ex.getMessage());
//	             }
//	          }
//	          String up=name;
//	          StringBuilder Sb=new StringBuilder(rem.toLowerCase());
//	    //PHASE 2 seq matcher  not working as expected
//	         int x=0;
//	    for(int i=0;i<name.length();i++) {
//	    	System.out.println("kyya h re!");
//	    try {
//	         	 
//	        if(rem.length()>=name.length()) 
//	        {
//	        	System.out.println("kkkkkppp");
//	            Boolean seq=rem.toLowerCase().charAt(i)==up.toLowerCase().charAt(i);
//	            sequence.add(seq);
//	        }
//	        else 
//	        {
////                 int x2=0;
////		         for(int j=i;j<rem.length();j++) {
////		        	 Boolean seq=false;
////		        	 if(x2!=2)
////		        	 {
////	                    seq=up.toLowerCase().charAt(i)==rem.toLowerCase().charAt(j);
////	                   System.out.print(rem.charAt(j)+"=-=-=-="+up.toLowerCase().charAt(i));
////	                   if(seq) {
////	                     sequence.add(seq);
////	                     break;
////	                   }
////	                   else {
////	                	   x2++;
////
////	                	   sequence.add(seq);
////	                	   System.out.println(seq);
////	                   }
////		        	 }
////	                   else {
////	                   }
////		        	 
////		         }
//	        	//THE-NIGHTMARE-ALGORITHMS
//	        	Boolean seq=name.toLowerCase().charAt(i)==Sb.toString().toLowerCase().charAt(i);
//	        	
//	        	if(seq) {
//	        		sequence.add(seq);
//	        		x=0;
//	        	}
//	        	else {
//	        	  if(x!=2) {
//	        		Sb.insert(i, '-');
//	        		System.out.println("New Name:"+Sb.toString()+"__Old string:"+rem);
//	        		sequence.add(seq);
//	        		x++;
//	        	  }
//	        	  else {
//	        		 if(Sb.toString().length()>rem.length()) {
//	        			 Sb.deleteCharAt(i-1);
//	        			  Sb.deleteCharAt(i-2);
//	        		//	  sequence.add(seq);
//                          System.out.println("New Name after deleting:"+Sb.toString()+"__Old string after deleting:"+up);
//	        		     x=0;
//	        		   // i-=1;
//	        		 }
//	        		 else {
//	        	     Sb.insert(i, '-');
//	        	   //   Sb.deleteCharAt(i);
//	        		//  sequence.add(seq);
//	        		  System.out.println("New Name again:"+Sb.toString()+"__Old string again:"+up);
//	        		  x=0;
//	        		  //i--;
//	        		 }
//	        		
//	        	  }
//	        	}
//		     } 
//	        }
//	        catch(Exception ex) {
//	        	 System.out.println("enough is enough!" +ex);
//	        	 sequence.add(false);
//	         }
//	      }
//		   
//	      System.out.println(map);
//	    Integer char_true_count=Collections.frequency(chars, true);  //WILL RETURN NUMBER OF TRUE OCCURENCE IN THE LIST IN INTEGER VALUE
//	    Integer char_false_count=Collections.frequency(chars, false);  //WILL RETURN NUMBER OF FALSE OCCURENCE IN THE LIST IN INTEGER VALUE
//	    Integer seq_true_count=Collections.frequency(sequence, true);
//	    Integer seq_false_count=Collections.frequency(sequence, false);
//	    System.out.println(char_true_count+"------"+char_false_count);
//	    System.out.println("Sequence count:"+seq_true_count+"-------"+seq_false_count);
//	    return "Done!";
//	}
//    public Integer resultFilter(String parsedResult) {
//    	return parsedResult.compareToIgnoreCase("rank");
//    }
//   // @Async
//    @GetMapping(value="/Data")
//    public String hoo(Model m){
//	 Flux<List<String>> c= Flux.just(Arrays.asList("minkk","blink","clink","link2"),Arrays.asList("minkk","blink","clink","link3"),Arrays.asList("minkk","blink","clink","link4"),Arrays.asList("minkk","blink","clink","link5"),Arrays.asList("minkk","blink","clink","link6"),Arrays.asList("minkk","blink","clink","link7"),Arrays.asList("minkk","blink","clink","link8"),Arrays.asList("minkk","blink","clink","link9"),Arrays.asList("minkk","blink","clink","link0")).log();
//	 ModelAndView mv=new ModelAndView("thymeleaf/ReactiveTemplate");
//	 m.addAttribute("data",new ReactiveDataDriverContextVariable(c, 100));  //  ReactiveDataDriverContextVariable SHOULD HAVE ONLY MULTIVALUED PUBLISHER LIKE FLUX..
//	 return "thymeleaf/ReactiveTemplate.html";
//    }
//    @GetMapping(value="/dream")
//    public ModelAndView page() {
//    	return new ModelAndView("thymeleaf/DataTest");
//    }
//    @GetMapping(value="/liveVideo",produces="video/webm")
//	public byte[] getVideos() throws IOException, URISyntaxException{
//    	System.out.println("CALLED FOR VIDEO!!");
//        byte[] j=Files.readAllBytes(Paths.get("C:/Users/Nikki singh/Pictures/Camera Roll/video1.mp4"));
//
////     System.out.println("Actuall Byte Length:"+j.length);
////        List<Byte> k=new ArrayList<Byte>();
////        
////        for(int i=0;i<j.length;i++) {
////         
////        	  //System.out.println("bosss");
////        	k.add(j[i]);
////          
////          
////     System.out.println("-----"+k[i]);
////       }
////        System.out.println("Byte Length:"+k.size());
////
////        //System.out.println("-----------"+new String(j));
////		//return Flux.fromArray(k);
////        return j;
////    	     System.out.println("I CALEED");
////    			return ResponseEntity.status(HttpStatus.SC_PARTIAL_CONTENT)  //RESPONSE ENTITY WILL LET US CONTROLL RESPONSE HEADER WITH BODY AND OTHER SPECIFIC INFO 
////    					.contentType(MediaTypeFactory      //WILL CONTROLL MEDIATYPE
////                                .getMediaType("C:/Users/Nikki singh/Downloads/The_Prestige_2006_Bluray.mp4")
////                                
////    							.orElse(MediaType.APPLICATION_OCTET_STREAM))
////    					.build();
//	   return j;
//    }
//    @RequestMapping(value = "/user")
//    public String user(Principal principal) {
//    	
//    
//       return "i m userrr";
//    }
//    @Autowired
//    private EhCacheCacheManager EhCh;
////    @GetMapping(value="/cache/{name}")
////    @Cacheable(value="userList",key="#name")
////    public List<user> getUser(@PathVariable("name")String name) {
////    	Cache c=EhCh.getCache("userCache");
////    	System.out.println(c.getName());
////    	System.out.println("Data is Recieveing!!!--no cacheing");
////    	return hd.getUser();
////    
////    }
//   
//}
//
//interface foo{
//	public String getName();
//	String getAge();
//}