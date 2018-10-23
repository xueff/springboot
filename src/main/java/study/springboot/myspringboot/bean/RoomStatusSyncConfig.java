package study.springboot.myspringboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuefei
 * @date 2018/9/1915:46
 */
//@Component
//@ConfigurationProperties(prefix="roomstatussyncsendtousay")
public class RoomStatusSyncConfig {
    private Boolean isQA;
    private String nsqAdminUrl;
    private String nsqOuterUrl;
    private String nSQLookupAdr;
    private String minioServerApiUrl;
    private String faceMatchApiUrl;
    private String roomControlApiUrl;

    public String getMinioServerApiUrl() {
        return minioServerApiUrl;
    }

    public void setMinioServerApiUrl(String minioServerApiUrl) {
        this.minioServerApiUrl = minioServerApiUrl;
    }

    public String getFaceMatchApiUrl() {
        return faceMatchApiUrl;
    }

    public void setFaceMatchApiUrl(String faceMatchApiUrl) {
        this.faceMatchApiUrl = faceMatchApiUrl;
    }

    public String getRoomControlApiUrl() {
        return roomControlApiUrl;
    }

    public void setRoomControlApiUrl(String roomControlApiUrl) {
        this.roomControlApiUrl = roomControlApiUrl;
    }

    public Boolean getQA() {
        return isQA;
    }

    public void setQA(Boolean QA) {
        isQA = QA;
    }

    public String getNsqAdminUrl() {
        return nsqAdminUrl;
    }

    public void setNsqAdminUrl(String nsqAdminUrl) {
        this.nsqAdminUrl = nsqAdminUrl;
    }

    public String getNsqOuterUrl() {
        return nsqOuterUrl;
    }

    public void setNsqOuterUrl(String nsqOuterUrl) {
        this.nsqOuterUrl = nsqOuterUrl;
    }

    public String getnSQLookupAdr() {
        return nSQLookupAdr;
    }

    public void setnSQLookupAdr(String nSQLookupAdr) {
        this.nSQLookupAdr = nSQLookupAdr;
    }
}
