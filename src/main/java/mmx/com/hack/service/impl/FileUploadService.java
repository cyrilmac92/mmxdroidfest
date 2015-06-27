package mmx.com.hack.service.impl;

import java.util.List;

import mmx.com.hack.domain.FileDomain;
import mmx.com.hack.domain.KeysDomain;
import mmx.com.hack.domain.UserDetails;
import mmx.com.hack.json.UploadRequestjson;
import mmx.com.hack.repository.FileRepo;
import mmx.com.hack.repository.KeyRepo;
import mmx.com.hack.repository.UserRepo;
import mmx.com.hack.service.IFileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService implements IFileUploadService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	KeyRepo keyRepo;
	
	@Autowired
	FileRepo fileRepo;
	
	
	
	 
	public void fileUpload(UploadRequestjson uploadRequestjson) throws Exception {
		
		
		UserDetails userDetails = new UserDetails();
		FileDomain fileDomain = new FileDomain();
		KeysDomain key = new KeysDomain();
		Long userId = validateAndFetchUserId(uploadRequestjson.getUser().getEmail(),
						uploadRequestjson.getUser().getPassword());
		if( userId != null) {
			userDetails.setUserId(userId);
			userDetails.setEmailId(uploadRequestjson.getUser().getEmail());
			userDetails.setPhoneNumber("phoneNumber");
			userDetails.setPassword(uploadRequestjson.getUser().getPassword());
			Long keyId = validateAndFetchKeyId(userDetails,uploadRequestjson.getAppId());
			if ( keyId != null) {
				
				key.setAppPackageId(uploadRequestjson.getAppId());
				key.setUserDetails(userDetails);
				key.setKeyId(keyId);
				
				fileDomain.setFileStream(uploadRequestjson.getBlob().getStream());
				//fileDomain.setSize(Long.parseLong(uploadRequestjson.getBlob().getSize()));
				fileDomain.setType(uploadRequestjson.getBlob().getType());
				fileDomain.setKeyDetails(key);
				fileRepo.save(fileDomain);
				
			}
			
		}
		
		
		
	}
	
	private long validateAndFetchUserId(String username, String password) throws Exception {
		
		
		UserDetails userDetails =  userRepo.findByemailId(username);
		
		
		
		if (userDetails == null) {
			userDetails = new UserDetails();
			userDetails.setEmailId(username);
			userDetails.setPassword(password);
			userDetails.setPhoneNumber("phoneNumber");
			userRepo.save(userDetails);
			return userDetails.getUserId();
			
		} else if(userDetails.getPassword().equalsIgnoreCase(password)) {
			return userDetails.getUserId();
		} else {
			throw new Exception("Invalid Password");
		}
		
	}
	
	
	private long validateAndFetchKeyId(UserDetails userDetails, String appPackageName) throws Exception {
		
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
