package mmx.com.hack.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "KEY_DETAILS")
public class KeysDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "KEY_ID")
	private Long keyId;
	
	@Column(name = "APP_PACKAGE")
	private String appPackageId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private UserDetails userDetails;

	public Long getKeyId() {
		return keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getAppPackageId() {
		return appPackageId;
	}

	public void setAppPackageId(String appPackageId) {
		this.appPackageId = appPackageId;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
	
	
	

}
