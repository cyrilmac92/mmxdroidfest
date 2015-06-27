package mmx.com.hack.controller;

import mmx.com.hack.json.UploadRequestjson;
import mmx.com.hack.json.UploadResponseJson;
import mmx.com.hack.service.impl.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public UploadResponseJson opportunityDetailsOnLocation(@RequestBody UploadRequestjson uploadRequestjson) {
		UploadResponseJson uploadResponse = new UploadResponseJson();
		
		try { 
				fileUploadService.fileUpload(uploadRequestjson);
				uploadResponse.setStatus("SUCESS");
				uploadResponse.setMessage("File uploaded sucessfully.");
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setStatus("ERROR");
			uploadResponse.setMessage("Error while uploading file");
		}
			
		
		return uploadResponse;
		
	}

	@RequestMapping(value = "/path", method = RequestMethod.POST,
			produces = { "application/json" },  consumes = { "application/json" })
	public String pathForward() {
		return null;
	}
}
