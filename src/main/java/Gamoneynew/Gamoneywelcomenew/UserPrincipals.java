package Gamoneynew.Gamoneywelcomenew;





import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import Phase1.Users.user;

public class UserPrincipals implements UserDetails,Serializable{
	private String username;
	private String password;
	private List<SimpleGrantedAuthority> AuthRoles;
	private static final long serialVersionUID = 20L;  //setting our own class custom serial id for tricking redis
    public UserPrincipals() {
    	
    }
	public UserPrincipals(String username,String password,List AuthRoles) {
		this.username=username;
		this.password=password;
		this.AuthRoles=AuthRoles;
		
	}
	//@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		// TODO Auto-generated method stub
		return this.AuthRoles;
	}

//	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password.trim();
	}

	//@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username.trim();
	}

	//@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

//	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;//change it later add a column with name enabled into database
	}
}
