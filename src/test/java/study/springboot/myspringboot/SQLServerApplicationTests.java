package study.springboot.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.myspringboot.model.sqlserver.HotelRoom;
import study.springboot.myspringboot.model.sqlserver.HotelRoomRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2122:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringbootApplication.class)
public class SQLServerApplicationTests {
    @Autowired
    HotelRoomRepository repository;
    @Test
    public void sqlServerConnectTest() throws SQLException {
        HotelRoom r = repository.findFirstByHotelMainIdAndRoomNo("26def324-c051-4626-b762-7815ee44cec4","101");
        System.out.println(r.getHotelMainId());
    }
    


}
