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
import mmx.com.hack.service.IKeyService;
import mmx.com.hack.service.IUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService implements IFileUploadService {
	
	@Autowired
	IUtilService utilService;
	
	@Autowired
	IKeyService keyService;
	
	@Autowired
	FileRepo fileRepo;
	 
	public void fileUpload(UploadRequestjson uploadRequestjson) throws Exception {
		
		
		UserDetails userDetails = new UserDetails();
		FileDomain fileDomain = new FileDomain();
		KeysDomain key = new KeysDomain();
		Long userId = utilService.validateAndFetchUserId(uploadRequestjson.getUser().getEmail(),
						uploadRequestjson.getUser().getPassword());
		if( userId != null) {
			userDetails.setUserId(userId);
			userDetails.setEmailId(uploadRequestjson.getUser().getEmail());
			userDetails.setPhoneNumber("phoneNumber");
			userDetails.setPassword(uploadRequestjson.getUser().getPassword());
			Long keyId = keyService.validateAndFetchKeyId(userDetails,uploadRequestjson.getAppId());
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
}
