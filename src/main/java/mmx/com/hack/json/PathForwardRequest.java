package mmx.com.hack.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PathForwardRequest {
	
	@JsonProperty("path")
	private String path;
	
	@JsonProperty("type")
	private String type;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
