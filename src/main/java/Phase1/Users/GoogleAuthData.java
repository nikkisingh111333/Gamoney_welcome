package Phase1.Users;

import java.util.List;

//{Name: [104678257807109404404], Granted Authorities: [[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash:wQs_awFgKo8ZyXKrwSG8GA, sub:104678257807109404404, email_verified:true, iss:https://accounts.google.com, given_name:Nikki, locale:en-GB, picture:https://lh6.googleusercontent.com/-I2mckjfCEVg/AAAAAAAAAAI/AAAAAAAAAAA/AAKWJJNPHNGsLtU-XIxDziBQnsi_owaf_w/s96-c/photo.jpg, aud:[1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com], azp:1072666384712-kfqtslm3juihhc3dtivalfu03i3mjipb.apps.googleusercontent.com, name:Nikki Singh, exp:2020-04-30T10:13:15Z, family_name:Singh, iat:2020-04-30T09:13:15Z, email:nikkikkc04@gmail.com}]}
public class GoogleAuthData {


    public  String given_name;
	public String picture;
	public String email;
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
