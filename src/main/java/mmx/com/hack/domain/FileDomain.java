package mmx.com.hack.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_DATA")
public class FileDomain {
	
	
	public KeysDomain getKeyDetails() {
		return keyDetails;
	}

	public void setKeyDetails(KeysDomain keyDetails) {
		this.keyDetails = keyDetails;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FILE_ID")
	private Long fileId;
	
	
	
	@Column( name = "FILE_STREAM", length = 1000 )
	
	private String fileStream;
	
	
	@Column( name = "FILE_SIZE" )
	private long size;
	
	
	@Column( name = "FILE_TYPE" )
	private String type;
	
	

	@Column( name = "FILE_MODIFIED_BY" )
	private String modifiedBy;
	
	
	@Column( name = "FILE_MODIFIED_AT" )
	private Date modifiedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "KEY_ID", insertable = false, updatable = false)
	private KeysDomain keyDetails;
	
	
	public String getFileStream() {
		return fileStream;
	}

	public void setFileStream(String fileStream) {
		this.fileStream = fileStream;
	}
	

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}




}
