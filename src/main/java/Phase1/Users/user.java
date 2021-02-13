package Phase1.Users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.*;
@XmlRootElement
@Entity
@Table(name="user",schema="public")
//@Getter @Setter
public class user implements Serializable,UserInterface{
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phnumber) {
		this.phone = phnumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String nationality;
	public void setNationality(String contry) {
		this.nationality=contry;
	}
	public String getNationality() {
		return nationality;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "username", unique = true, nullable = true)
    private String username;
	@Column(name = "password", unique = false, nullable = true)
	private String password;
	@Column(name = "email", unique = true, nullable = true)
	private String email;
	@Column(name = "phone", unique = true, nullable = true)
	private String phone;
	@Column(name="role",nullable=true)
	private String role;
	public String getRoles() {
		return role;
	}
	public void setRoles(String r) {
		this.role=r;
	}
	public user() {
		
	}
	public user(String username,String password,String email,String number,String roles) {
		this.username=username;
		this.password=password;
		this.email=email;
		this.phone=number;
		this.role=roles;
	}
}
