package Gamoneynew.Gamoneywelcomenew;

//import java.util.Arrays;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.web.SignInAdapter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.NativeWebRequest;
//@Component
//public class FacebookLogin implements SignInAdapter {
//
//	@Override
//	public String signIn(String userId, Connection<?> conn, NativeWebRequest request) {
//		// TODO Auto-generated method stub
//		System.out.println("BHAI KA NAME_"+conn.fetchUserProfile().getFirstName());
//		 
//	         
//	        SecurityContextHolder.getContext().setAuthentication(
//	          new UsernamePasswordAuthenticationToken(
//	          conn.getDisplayName(), null, 
//	          Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
//	         
//		return null;
//	}
//
//}
