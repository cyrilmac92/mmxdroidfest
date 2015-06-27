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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FILE_ID")
	private Long fileId;
	
	
	
	@Column( name = "FILE_STREAM" )
	@Lob
	private byte[] fileimage;
	
	
	@Column( name = "FILE_SIZE" )
	private long size;
	
	
	@Column( name = "FILE_TYPE" )
	private String Type;
	
	@Column( name = "FILE_MODIFIED_BY" )
	private String ModifiedBy;
	
	
	@Column( name = "FILE_MODIFIED_AT" )
	private Date modifiedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "KEY_ID", insertable = false, updatable = false)
	private KeysDomain keyDetails;
	
	
	public byte[] getFileimage() {
		return fileimage;
	}

	public void setFileimage(byte[] fileimage) {
		this.fileimage = fileimage;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
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
