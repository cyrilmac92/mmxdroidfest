package mmx.com.hack.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PathForwardRequest {
	
	@JsonProperty("User")
	UserDetailsJson user;

	@JsonProperty("ApplicationPackageID")
	String appId;

	@JsonProperty("Path")
	String path;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
