package mmx.com.hack.controller;

import mmx.com.hack.json.UploadRequestjson;
import mmx.com.hack.json.UploadResponseJson;
import mmx.com.hack.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/file")
public class FileUploadController {
	
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,
					produces = { "application/json" },  consumes = { "application/json" })
	public UploadResponseJson opportunityDetailsOnLocation(UploadRequestjson uploadRequestjson) {
		UploadResponseJson uploadResponse = new UploadResponseJson();
		
		try { 
				fileUploadService.fileUpload(uploadRequestjson);
				uploadResponse.setStatus("SUCESS");
				uploadResponse.setMessage("File uploaded sucessfully.");
		} catch (Exception e) {
			uploadResponse.setStatus("ERROR");
			uploadResponse.setMessage("Error while uploading file");
		}
			
		
		return uploadResponse;
		
	}

}
