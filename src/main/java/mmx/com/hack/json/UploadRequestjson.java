package mmx.com.hack.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * 
 * This class is a request json for uploading a file and storing it in the DB. 
 * Associated with files table.
 * @author Mac - cyril
 *
 */

@JsonPOJOBuilder
public class UploadRequestjson {

	@JsonProperty("User")
	UserDetailsJson user;
	

	@JsonProperty("ApplicationPackageID")
	String appId;

	@JsonProperty("BlobEntity")
	BlobDetailsJson blob;

	public UserDetailsJson getUser() {
		return user;
	}

	public void setUser(UserDetailsJson user) {
		this.user = user;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public BlobDetailsJson getBlob() {
		return blob;
	}

	public void setBlob(BlobDetailsJson blob) {
		this.blob = blob;
	}

}
