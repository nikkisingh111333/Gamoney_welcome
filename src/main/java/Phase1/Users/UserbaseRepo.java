package Phase1.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@Repository
public interface UserbaseRepo extends CrudRepository<user,Integer> {
	 
}
