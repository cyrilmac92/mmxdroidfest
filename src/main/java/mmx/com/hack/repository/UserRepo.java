package mmx.com.hack.repository;

import mmx.com.hack.domain.UserDetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface UserRepo extends CrudRepository<UserDetails, Long>{
	
	@Query("SELECT userId FROM UserDetails u WHERE u.emailId like :emailId and u.password like :password")
	public String searchWithJPQLQuery(@Param("emailId") String emailId, 
			@Param("password") String password);
	
	

}
