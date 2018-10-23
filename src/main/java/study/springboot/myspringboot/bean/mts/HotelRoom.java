package study.springboot.myspringboot.bean.mts;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2516:32
 */
@Entity
@Table(schema = "dbo")
public class HotelRoom {
    @javax.persistence.Id
    @GeneratedValue
    private int Id;
    @Column(nullable = false)
    private String roomNo;
    @Column(nullable = false)
    private String hotelMainId;
    private int roomTypeId;
    private String reMark;
    private String floor;
    private String tel;
    @Column(nullable = false)
    private int state;
    private String updatedBy;
    private Date updatedTime;
    private String roomConfigId;
    private boolean useXctrl;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getHotelMainId() {
        return hotelMainId;
    }

    public void setHotelMainId(String hotelMainId) {
        this.hotelMainId = hotelMainId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRoomConfigId() {
        return roomConfigId;
    }

    public void setRoomConfigId(String roomConfigId) {
        this.roomConfigId = roomConfigId;
    }

    public boolean isUseXctrl() {
        return useXctrl;
    }

    public void setUseXctrl(boolean useXctrl) {
        this.useXctrl = useXctrl;
    }
}

