package study.springboot.myspringboot.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection="DeviceStatus")
public class DeviceStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String type;
    private long date;

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    private String business;

    @Field("Light")
    private List<Device> Light = new ArrayList<>();
    @Field("Curtain")
    private List<Device> Curtain = new ArrayList<>();

    @Field("Host")
    private List<Device> Host = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<Device> getLight() {
        return Light;
    }

    public void setLight(List<Device> light) {
        Light = light;
    }

    public List<Device> getCurtain() {
        return Curtain;
    }

    public void setCurtain(List<Device> curtain) {
        Curtain = curtain;
    }

    public List<Device> getHost() {
        return Host;
    }

    public void setHost(List<Device> host) {
        Host = host;
    }
}
