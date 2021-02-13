package Phase1.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

///'''.
@RestController
public class TempController {
	@Autowired
	ApplicationContext ac;
   // @Autowired
    TaskScheduler ts;
    @Autowired
    RestTemplate res;
   // @Autowired
   // ConnectionFactory h2;
//    @RequestMapping("/chalBC")
//    public void get() {
//    	
//    	ScheduleTaskTEST STT=(ScheduleTaskTEST) ac.getBean("scheduleClass");
//    	TaskScheduler ts=STT.ts;
//    	ScheduledFuture sf=ts.schedule(new Runnable(){
//    		System.out.println("tu to ekor baar chalegga"+Thread.currentThread().getName());
//    	}, new CronTrigger("0 1/1 23 * * *"));
//   
//    	ScheduledFuture sf2=ts.schedule(()->{
//    		System.out.println("pappu is baes"+Thread.currentThread().getName());
//    	}, new CronTrigger("0 1/1 23 * * *"));
//    
//    	
//   }
//   @Autowired
//   HibernateDataHandler hd;
   @GetMapping(value="/temp",produces=	MediaType.APPLICATION_JSON_VALUE)
   public Match hh() {
	   System.out.println("im here 4 u");
	   return res.getForObject("http://pubgm-client/something", Match.class);
   }
   @GetMapping(value="/Admin_portal")
   public ModelAndView getTest() {
	   return new ModelAndView("thymeleaf/welcome");
   }
//   @RequestMapping(value="/testflux" ,produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
//   public ReactiveENTITY test() throws IOException {
//	   System.out.println("i m running TESTFLUXXXXXXXXXXXX");
//	  ReactiveENTITY rn=new ReactiveENTITY();
//	  rn.id=1;
//	  rn.name="minki";
//	  rn.pass="popppat";
//	  rr.save(rn);
////	  Mono<Connection> m=(Mono<Connection>) h2.create();
////	  m.flatMapMany((ch)->ch.createStatement("insert into ReactiveENTITY(id,name,pass) values($1,$2,$3)").bind("$1", 12).bind("$2", "NIKKI").bind("$3", "BEAST").execute());
////	  
//	  
//	  
//	return rr.find("nikki");
//   }
}
class Match {
	  String name;
	  List<Integer> lo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getLo() {
		return lo;
	}

}