package mmx.com.hack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;


import mmx.com.hack.domain.UserDetails;
import mmx.com.hack.repository.UserRepo;
import mmx.com.hack.service.IUtilService;

public class UtilService implements IUtilService{

	@Autowired
	UserRepo userRepo;
	
	public long validateAndFetchUserId(String userEmail, String password) throws Exception {
		
		UserDetails userDetails =  userRepo.findByemailId(userEmail);
		
		if (userDetails == null) {
			userDetails = new UserDetails();
			userDetails.setEmailId(userEmail);
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
	
	/**
	 * Returns a user object if validated. Throws exception on invalid password
	 * @param userEmail
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public UserDetails validateUser(String userEmail,String password) throws Exception
	{
		UserDetails userDetails =  userRepo.findByemailId(userEmail);
		if(userDetails != null) {
			if(!userDetails.getPassword().equals(password)) {
				throw new Exception("Invalid Password");
			}
			return userDetails;
		}
		 return null;
	}
}
