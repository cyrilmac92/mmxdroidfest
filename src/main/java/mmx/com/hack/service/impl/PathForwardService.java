package mmx.com.hack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mmx.com.hack.RestoreBackupConstants;
import mmx.com.hack.domain.KeysDomain;
import mmx.com.hack.domain.PathDomain;
import mmx.com.hack.domain.UserDetails;
import mmx.com.hack.json.PathForwardRequest;
import mmx.com.hack.repository.PathForwardRepo;
import mmx.com.hack.service.IKeyService;
import mmx.com.hack.service.IPathForward;
import mmx.com.hack.service.IUtilService;

@Service
public class PathForwardService implements IPathForward{

	@Autowired
	private IUtilService utilService;
	
	@Autowired 
	IKeyService keyService;
	
	@Autowired
	private PathForwardRepo pathForwardRepo;
	
	@Override
	public void savePath(PathForwardRequest pathForwardRequest) throws Exception {

		UserDetails userDetails = new UserDetails();
		Long userId = utilService.validateAndFetchUserId(
				pathForwardRequest.getUser().getEmail(), pathForwardRequest.getUser().getPassword());
		
		userDetails.setEmailId(pathForwardRequest.getUser().getEmail());
		userDetails.setPhoneNumber("phoneNumber");
		userDetails.setPassword(pathForwardRequest.getUser().getPassword());
		
		if(userId != null && userId != 0) {
			userDetails.setUserId(userId);
		}
		PathDomain pathDomain = new PathDomain();
		KeysDomain keysDetails = new KeysDomain();
		
		Long keyId = keyService.validateAndFetchKeyId(userDetails, pathForwardRequest.getAppId());
		
		keysDetails.setAppPackageId(pathForwardRequest.getAppId());
		keysDetails.setUserDetails(userDetails);
		keysDetails.setKeyId(keyId);
		
		pathDomain.setKeyDetails(keysDetails);
		pathDomain.setPath(pathForwardRequest.getPath());
		pathDomain.setStorageType(RestoreBackupConstants.EXTERNAL_ENTITY);
		
		pathForwardRepo.save(pathDomain);
		
	}
}
