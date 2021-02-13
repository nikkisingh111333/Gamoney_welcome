package Phase1.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
  @Autowired
  protected JavaMailSender jms;
  @Autowired
  protected HibernateDataHandler hd;
  public void mailSend(String To) {

      SimpleMailMessage msg = new SimpleMailMessage();
      msg.setTo(To);
     // msg.setFrom("nikkikkc04@gmail.com");
     
      msg.setSubject("Testing from Spring Boot");
      msg.setText("<h1><link href="+"https://localhost:8998/apps/welcome/welcome"+"></link></h1>");
      jms.send(msg);
   }
  public void AttachmentFileMAil(String... to) throws MessagingException, FileNotFoundException {
	  MimeMessage msg=jms.createMimeMessage();
	  MimeMessageHelper helper = new MimeMessageHelper(msg, true);//help to Construct the MimeMessage for java mail
      helper.setTo(to);

      helper.setSubject("Testing from Spring Boot");
      
      // default = text/plain
      helper.setText("Check attachment for image!");
       
      // true = text/html
     // helper.setText("<h1><a href="+"https://localhost:8998/apps/welcome/welcome"+"></a></h1>", true);
    //  helper.setText("this is link", "<h1><a href="+"https://localhost:8998/apps/welcome/welcome"+"></a></h1>");
      String message = "<i>Greetings!</i><br>";
      message += "<b>WELCOME TO XXXXX.live></b><br>";  //we will change it
      message += "<font color=red>Account_Details_fetching in progress.......[connecting to your localFiles]</font>";
      message+="<font color=red>THIS email is to inform you someone is unAuthorised stealing your personal data which may include your</font>";
      message+="<ul><li>contacts</li><li>personal messages</li><li>media contents(photo,video,image)</li><li>other importatnt documents</li></ul>";
      message+="<font color=red>SECURE IT FAST.GET YOUR BACKUP READY!!</font>";
      msg.setContent(message, "text/html");
   //   helper.addAttachment("my_photo.png",new FileDataSource( new File("C:\\Users\\Nikki singh\\Downloads\\large.jpg")));
      //helper.addAttachment("my_photo.png", new File("C:\\Users\\Nikki singh\\Downloads\\large.jpg"));
      jms.send(msg);
  }
  
 // @Scheduled(cron="0 1/2 23 * * ?")
  public void EmailSender() {
	 List<user> u=hd.getUser();
	 System.out.println("Sending emails");
	 try {
		 String[] u_emails=new String[u.size()];
		 int i=0;
		 for(user us:u) {
		    u_emails[i]=us.getEmail();
		    i++;
		 }
		 this.AttachmentFileMAil(u_emails);
	 } 
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	   System.out.println("Exception Occurs:"+e.getMessage());
	} 
	 catch (MessagingException e2) {
		// TODO Auto-generated catch block
		System.out.println("Exception Occurs:"+e2.getMessage());
	}
  }
}
