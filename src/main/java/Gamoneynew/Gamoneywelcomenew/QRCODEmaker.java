package Gamoneynew.Gamoneywelcomenew;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class QRCODEmaker {

	public static void main(String[] args) throws ParseException, IOException {
		
		// TODO Auto-generated method stub
		HttpClient hcl=HttpClients.createDefault();
		HttpPost h=new HttpPost("https://www.qrcode-monkey.com/qr/custom");
		//MULTIPARTENTITYBUILDER USE FOR SENDING IMAGE OR ANYOTHER BLOB TO THE TARGET SERVER AND CREATE A BODY
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.setMode(HttpMultipartMode.STRICT); //I DONT KNOW WHAT EXACTLY IT IS WE WILL INVESTIGATE LATER ON
	    //Creating DEFAULT form body ,NOT OUR BELOVED JSON FORMAT
	    //IMAGE AS INPUT STREAM WITH ITS TYPE //SECRET API KEY
	    builder.addTextBody("data", "https://www.qrcode-monkey.com");
	    builder.addTextBody("config", "{body:circle,logo:#facebook}");
	    builder.addTextBody("size", "300");
	    builder.addTextBody("download", "false");
	    builder.addTextBody("file", "svg");
	    
	    
	    org.apache.http.HttpEntity hc= builder.build(); //GETTING HTTPENTITY OF THIS MUTLIPART BODY
	    h.setEntity(hc); //setting HttpENTITY WITH A REQUEST FORM BODY IN IT
		HttpResponse res= hcl.execute(h);
		String result = EntityUtils.toString(res.getEntity());//RESULT STRING 
	    System.out.println(result);
	}

}
