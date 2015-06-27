package mmx.com.hack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mmx.com.hack.domain.KeysDomain;
import mmx.com.hack.domain.UserDetails;
import mmx.com.hack.repository.KeyRepo;
import mmx.com.hack.service.IKeyService;

public class KeyService implements IKeyService{

	
	@Autowired
	KeyRepo keyRepo;
	
	public long validateAndFetchKeyId(UserDetails userDetails, String appPackageName) throws Exception {
		
		List<KeysDomain> keys = keyRepo.findByuserDetails(userDetails);
		boolean appExists = false;
		long keyId = 0;
		
		try {
		if(!keys.isEmpty()) {
			for( KeysDomain key : keys ) {
				
				if( key.getAppPackageId().equalsIgnoreCase(appPackageName)) {
					appExists = true;
					return key.getKeyId();
				}
				
			}
		}
		else if( !keys.isEmpty() || !appExists) {
			KeysDomain key = new KeysDomain();
			key.setUserDetails(userDetails);
			key.setAppPackageId(appPackageName);
			keyRepo.save(key);
			return key.getKeyId();	
		}
		
		} catch(Exception e) {
			throw new Exception("App upload failed");
		}
		
		return keyId;
		
	}
	
}
