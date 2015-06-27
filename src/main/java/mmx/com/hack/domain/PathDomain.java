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
@Table(name = "PATH_DATA")
public class PathDomain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PATH_ID")
    private Long pathId;

    @Column( name = "PATH" )
    @Lob
    private String path;

    @Column( name = "STORAGE_TYPE" )
    private String storageType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "KEY_ID", insertable = false, updatable = false)
    private KeysDomain keyDetails;

    public KeysDomain getKeyDetails() {
        return keyDetails;
    }

    public void setKeyDetails(KeysDomain keyDetails) {
        this.keyDetails = keyDetails;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }
}
