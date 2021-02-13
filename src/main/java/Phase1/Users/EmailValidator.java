package Phase1.Users;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
@Service
public class EmailValidator {  // Email validating SERVICE CLASS
  public String validator(String email) {
	  try {
	  String API_KEY = "d00a6f610cdc1cc7b5a6c1f183bf049e895b4906d737db5dad07a1cd5d53"; // Replace API_KEY with your API Key
      String EMAIL_ADDRESS = email; // Email address which need to be verified

      String url = "http://api.quickemailverification.com/v1/verify?email="+EMAIL_ADDRESS+"&apikey="+API_KEY;

      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      if(responseCode!=200) {
    	  String error="ServerProblems";
    	  return error;
      }
      else {
      System.out.println("Sending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);
     
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine=null;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
      }
      in.close();

      //print result
      System.out.println(response.toString());
		Gson g=new Gson();
		checkEmails cm=g.fromJson(response.toString(),checkEmails.class);
		System.out.println(cm.getResult());
		return cm.getResult();
      }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {		
		// TODO Auto-generated catch block
		return null;
	}
	  
	return null;				
	 
  }
//  public static void main(String[] h) {
//	  new EmailValidator().validator("mikkimouse125m@gmail.com");
//  }
  class checkEmails{
	  private String result;
	  private String safe_to_send;
	public String getResult() {
		return result;
	}
	public String getSafe_to_send() {
		return safe_to_send;
	} 
	  
  }
}
