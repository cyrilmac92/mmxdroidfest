package mmx.com.hack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mmx.com.hack.domain.UserDetails;
import mmx.com.hack.json.PathForwardRequest;
import mmx.com.hack.repository.PathForwardRepo;
import mmx.com.hack.repository.UserRepo;
import mmx.com.hack.service.IPathForward;
import mmx.com.hack.service.IUtilService;

@Service
public class PathForwardService implements IPathForward{

	@Autowired
	private IUtilService utilService;
	
	@Autowired
	private PathForwardRepo pathForwardRepo;
	
	@Autowired
	private UserRepo userRepo;
	
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
		//register the user and then save the path			
		userRepo.save(userDetails);
		
		
	}
}
