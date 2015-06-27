package mmx.com.hack.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="keyDetails")
	private List<FileDomain> files;

	public Long getKeyId() {
		return keyId;
	}

	public List<FileDomain> getFiles() {
		return files;
	}

	public void setFiles(List<FileDomain> files) {
		this.files = files;
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
