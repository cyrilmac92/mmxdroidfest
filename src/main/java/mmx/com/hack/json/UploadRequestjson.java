package mmx.com.hack.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class UploadRequestjson {

	@JsonProperty("User")
	UserDetailsJson status;
	

	@JsonProperty("ApplicationPackageID")
	String appId;

	@JsonProperty("BlobEntity")
	BlobDetailsJson message;
	
	public UserDetailsJson getStatus() {
		return status;
	}

	public void setStatus(UserDetailsJson status) {
		this.status = status;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public BlobDetailsJson getMessage() {
		return message;
	}

	public void setMessage(BlobDetailsJson message) {
		this.message = message;
	}

	
	

}
