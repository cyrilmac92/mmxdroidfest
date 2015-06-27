package mmx.com.hack.controller;

import mmx.com.hack.json.UploadResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/file")
public class FileUploadController {
	
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public UploadResponse opportunityDetailsOnLocation() {
		UploadResponse uploadResponse = new UploadResponse();
		
		uploadResponse.setStatus("SUCESS");
		uploadResponse.setMessage("File uploaded sucessfully.");
		
		return uploadResponse;
		
	}

}
