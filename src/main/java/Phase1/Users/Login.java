package Phase1.Users;

import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Component;
@Component
@Configurable(preConstruction=true,dependencyCheck=true)
//@EnableSpringConfigured
public class Login {   //Fetching Registerd Users Of a WebApp from hibernate database!
//	public String getUsername() {
//		return username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	private String username;
//	private String password;
//	@Autowired
//	private HibernateDataHandler hd;//doubt
//	public String loginCredentials(HttpSession session,String username,String password) {
//		System.out.println(username+"    -- "+password);
//		System.out.println(hd.getUser());
//		List<user> l=hd.getUser();
//		final Iterator it=l.iterator();
//		while(it.hasNext()) {
//			user u=(user) it.next();
//			System.out.println(u.getPassword()+"======="+u.getUsername());
//			if(u.getUsername().equals((String)username)&&u.getPassword().equals((String)password)) {
//				System.out.println("SESSION-ID::"+session.getId()+"--"+session.isNew());
//				session.setAttribute("user", username);
//				session.setAttribute("pass",password);
//				System.out.println("loggedIn success");
//				String name=u.getUsername();
//				return name;
//			}
//}
//		return null;
//	}
}
