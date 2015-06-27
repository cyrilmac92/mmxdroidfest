package mmx.com.hack.repository;

import java.util.List;

import mmx.com.hack.domain.KeysDomain;
import mmx.com.hack.domain.UserDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KeyRepo extends CrudRepository<KeysDomain, Long>{
	
	public List<KeysDomain> findByuserDetails(@Param("userDetails") UserDetails userDetails);
	
	

}
