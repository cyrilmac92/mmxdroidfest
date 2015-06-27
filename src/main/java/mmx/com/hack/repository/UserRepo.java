package mmx.com.hack.repository;

import mmx.com.hack.domain.UserDetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface UserRepo extends CrudRepository<UserDetails, Long>{
	
	@Query("SELECT USER_DETAILS FROM USER_DETAILS u WHERE u.USER_EMAIL like :emailId and u.USER_PASSWORD like :password")
	public long searchWithJPQLQuery(@Param("emailId") String emailId, 
			@Param("password") String password);
	
	

}
