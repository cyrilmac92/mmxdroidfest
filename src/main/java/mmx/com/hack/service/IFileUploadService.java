package mmx.com.hack.service;

import mmx.com.hack.json.UploadRequestjson;

public interface IFileUploadService {

	public void fileUpload(UploadRequestjson uploadRequestjson) throws Exception;
}
