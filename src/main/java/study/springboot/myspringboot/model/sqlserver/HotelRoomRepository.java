package study.springboot.myspringboot.model.sqlserver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/1916:44
 */
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer> {
    HotelRoom findFirstByHotelMainIdAndRoomNo(String hotelId, String roomNo);

    List<HotelRoom> findByHotelMainId(String hotelId);
}
