package OnBoardApp.FAQ.repository;

import OnBoardApp.FAQ.model.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<user,Long> {
	
	@Query(
			  value = "SELECT * FROM USERS u WHERE u.status = 1", 
			  nativeQuery = true)
	List<user> findmytest();
	
}
