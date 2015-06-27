package mmx.com.hack.service.impl;

import mmx.com.hack.json.UploadRequestjson;
import mmx.com.hack.service.IFileUploadService;
import mmx.com.hack.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService implements IFileUploadService {
	
	@Autowired
	UserRepo userRepo;
	
	public void fileUpload(UploadRequestjson uploadRequestjson) {
		
		String userId = validateAndFetchUserId(uploadRequestjson.getUser().getEmail(),
						uploadRequestjson.getUser().getPassword());
	}
	
	private String validateAndFetchUserId(String username, String password) {
		
		return userRepo.searchWithJPQLQuery(username, password);
		
		
	}
}
