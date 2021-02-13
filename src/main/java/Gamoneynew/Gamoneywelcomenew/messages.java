package Gamoneynew.Gamoneywelcomenew;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("msg")
public class messages {
  @Id 
  Integer id;
  String name;
  String age;
  public Integer getId() {
	  return this.id;
  }
  public void setId(Integer k) {
	  this.id=k;
	  
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
}
