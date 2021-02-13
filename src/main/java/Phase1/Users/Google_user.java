package Phase1.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="google_user",schema="public")
public class Google_user implements UserInterface {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username", unique = true, nullable = true)
    private String username;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "phone",length = 11, unique = true, nullable = true)
	private String phone;
	@Column(name = "picture", nullable = true)
	private String picture;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Google_user() {
		
	}
	public Google_user(String user,String email,String phone,String picture) {
		this.username=user;
		this.phone=phone;
		this.email=email;
		this.picture=picture;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
