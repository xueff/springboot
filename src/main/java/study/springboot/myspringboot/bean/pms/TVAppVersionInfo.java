package study.springboot.myspringboot.bean.pms;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2516:31
 */
@Entity
@Table(schema = "dbo")
public class TVAppVersionInfo {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String packageName;
    @Column(nullable = false)
    private int versionCode;
    @Column(nullable = false)
    private String versionName;
    @Column(nullable = false)
    private String channelDataFilePath;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private String updatedBy;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getChannelDataFilePath() {
        return channelDataFilePath;
    }

    public void setChannelDataFilePath(String channelDataFilePath) {
        this.channelDataFilePath = channelDataFilePath;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

