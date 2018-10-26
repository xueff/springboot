package com.example.databasesql;

import com.example.databasesql.mts.HotelRoom;
import com.example.databasesql.mts.HotelRoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
@SpringBootTest(classes = DatabaseSqlApplication.class)
public class SQLServerApplicationTests  {
    @Autowired
    DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    HotelRoomRepository repository;
    @Test
    public void getBean() throws SQLException {
        HotelRoom r = repository.findFirstByHotelMainIdAndRoomNo("26def324-c051-4626-b762-7815ee44cec4","101");
        System.out.println(r.getHotelMainId());
    }

    @Test
    public void sqlServerConnectTest() throws SQLException {
        System.out.println(dataSource);
        Connection connect = dataSource.getConnection();
        System.out.println(connect);
    }


    @Test
    public void callableStatement() {

        List resultList = (List) jdbcTemplate.execute(new CallableStatementCreator() {
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                String storedProc = "{call SP_JobTag_UpdateByRoomState()}";// 调用的sql
                CallableStatement cs = con.prepareCall(storedProc);
                //cs.setInt(1,1);
                return cs;
            }
        }, new CallableStatementCallback() {
            public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                //ResultSetMappingBinder<RoomStatusInfo> resultSetMapper = new ResultSetMappingBinder<RoomStatusInfo>();

                ResultSet rs = cs.executeQuery();
                ResultSetMetaData rmd = rs.getMetaData();
                int columnCount = rmd.getColumnCount();
                List<Map<String, Object>> resultsMap = new ArrayList<Map<String, Object>>();
                while (rs.next()) {
                    Map<String, Object> mso = new HashMap<String, Object>(columnCount);
                    for (int i = 1; i <= columnCount; i++) {
                        mso.put(rmd.getColumnName(i), rs.getObject(i));
                        //mso.put(s, rs.getString(s));
                    }
                    resultsMap.add(mso);

                }
                rs.close();
                return resultsMap;
            }
        });
        System.out.println(resultList.get(0));
    }
    


}
