package com.example.databasesql.mts;//package study.springboot.myspringboot.bean.mts;

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
