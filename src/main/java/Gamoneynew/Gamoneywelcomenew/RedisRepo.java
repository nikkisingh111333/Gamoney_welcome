package Gamoneynew.Gamoneywelcomenew;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepo  {
	String getName();
	String getAge();
}
