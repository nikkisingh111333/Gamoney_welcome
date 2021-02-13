package Phase1.Users;



import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sun.xml.txw2.annotation.XmlElement;

@Entity
@XmlRootElement

@Table(schema="public",uniqueConstraints = @UniqueConstraint(columnNames ="username"))

public class star_wallet implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)

	private int id;
	@Column(length=50)

	private String username; //=====CustumerId
	@Column(length=30)
	
	private Integer totatstars;
	@Column(length=40)
	
	private String addedinandat;

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getTotalMoney() {
		return totatstars;
	}
	public void setTotalMoney(Integer totalMoney) {
		totatstars = totalMoney;
	}
	public String getAddedInAndAt() {
		return addedinandat;
	}
	public void setAddedInAndAt(String addedInAndAt) {
		this.addedinandat = addedInAndAt;
	}

}
