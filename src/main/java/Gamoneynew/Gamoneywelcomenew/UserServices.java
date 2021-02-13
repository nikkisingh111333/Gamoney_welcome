package Gamoneynew.Gamoneywelcomenew;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Phase1.Users.HibernateDataHandler;
import Phase1.Users.UserInterface;
import Phase1.Users.user;
@Service
public class UserServices implements UserDetailsService  {
    @Autowired
    private HibernateDataHandler hbd;
	//@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Authentication reading from DBMS!!!");
		user user=(Phase1.Users.user) hbd.fetchOneUser(username,user.class);
		if(user!=null) {
		    System.out.println("ROLES--"+user.getRoles()+"--------"+user.getRoles().length());
			    UserPrincipals userdetails=new UserPrincipals(user.getUsername(),user.getPassword(),Arrays.asList((SimpleGrantedAuthority)new SimpleGrantedAuthority("ROLE_"+user.getRoles().trim())));//PROVIDING USERDETAILS INFORMATION INTERFACE TO SPRING SECURITY BY USING FUNCTIONAL JAVA PROGRAMMING 
			    return userdetails;
	    }
		else {
			System.out.println("no users");
			return new UserPrincipals(null,null, null);
		}

  }
}
