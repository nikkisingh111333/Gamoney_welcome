package Phase1.Users;
//{Name: [104678257807109404404], Granted Authorities: [[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash:wQs_awFgKo8ZyXKrwSG8GA, sub:104678257807109404404, email_verified:true, iss:https://accounts.google.com, given_name:Nikki, locale:en-GB, picture:https://lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg, aud:[1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com], azp:1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com, name:Nikki Singh, exp:2020-04-30T10:13:15Z, family_name:Singh, iat:2020-04-30T09:13:15Z, email:nikkikkc04@gmail.com}]}

import java.util.List;

import com.google.gson.Gson;

class obj{
	List<Att> Att;
	
}class Att{

	String name;
	String roll;
	public String getName() {
		return name;
	}
	public String getRoll() {
		return roll;
	}
}
public class ReusableTest {

//	public static void main(String[] args) {
//		System.out.println("https://lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg".length());
//		String json="Name: [104678257807109404404], Granted Authorities: [[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash=IUKUu0sYCD3WiCaIB-wBpA, sub=104678257807109404404, email_verified=true, iss=https://accounts.google.com, given_name=Nikki, locale=en-GB, picture=https://lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg, aud=[1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com], azp=1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com, name=Nikki Singh, exp=2020-05-01T09:39:00Z, family_name=Singh, iat=2020-05-01T08:39:00Z, email=nikkikkc04@gmail.com}]";
//      String cut="{UserAttributes:[{at_hash:DTKckF9VCP4evbMpPW_9JQ,sub:104678257807109404404,email_verified:true,given_name:Nikki,locale:en-GB,azp:1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com,name:NikkiSingh,exp:2020-04-30T11-31-23Z,family_name:Singh,iat=2020-04-30T10-31-23Z,email=nikkikkc04@gmail.com}]}";
//		System.out.println(json.indexOf("Attributes")+"---"+json.charAt(192));  //image picture=https-//lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg
//		String h=json.split("User Attributes: ")[1].replace(":", "-").replace("/","^").replace(" ", "").trim();
//		
//		System.out.println(h);
//		System.out.println(h.length());
//		Gson g=new Gson();
//	//	h="{name=https-\\lh6.googleusercontent.com-I2mckjfCEVgAAAAAAAAAAIAAAAAAAAAAAAAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_ws96-cphoto.jpg,roll:mikkki}";
//		//Att l=g.fromJson(h,Att.class);
//
//		//System.out.println(l.getName()+"--"+l.getRoll());
//		GoogleAuthData[] j=g.fromJson(h, GoogleAuthData[].class);
//		System.out.println(j[0].getGiven_name()+"--"+j[0].getEmail()+"--"+j[0].getPicture());
//
//	}

}
