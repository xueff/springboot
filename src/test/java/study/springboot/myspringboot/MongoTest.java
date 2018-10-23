package study.springboot.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.myspringboot.bean.Device;
import study.springboot.myspringboot.bean.DeviceStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/513:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;


        /*
        db.getCollection('DeviceStatus').find({"type":"hotel","business":"bb545405-85b0-4243-873d-a52cfdf14cac","date":"2018-08-30"})

        db.getCollection('DeviceStatus').update({"type":"hotel","business":"bb545405-85b0-4243-873d-a52cfdf14cac","date":"2018-08-30"},{$push:{"Light":
            {
                    "path" : "/.dentry/bb545405-85b0-4243-873d-a52cfdf14cac/101房间/床头灯6",
                    "timestamp" : 1535529212,
                    "status" : {
                        "Switch" : "On"
                    }
                }
                }
                })
         */

    @Test
    public void TestService() {
//                MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "DeviceStatus"));

        //long data = DateUtils.getDayBegin().getTime()/1000;
        for(int i=1;i<10;i++){

            DeviceStatus de = new DeviceStatus();
            de.setType("hotel");
            de.setDate(new Date().getTime());
            de.setBusiness(String.valueOf(i));
            List<Device> light = new ArrayList<>();
            Device dev = new Device();
            dev.setPath("/.dentry/bb545405-85b0-4243-873d-a52cfdf14cac/101房间/床头灯"+i);
            dev.setTimestamp(new Date().getTime()/1000);
            light.add(dev);
            de.setLight(light);

            long start = System.currentTimeMillis();
//                        mongoTemplate.updateFirst(Query.query(
//                                where("type").is("hotel")
//                                        .and("date").is("2018-08-49")
//                                        .and("business").is("bb545405-85b0-4243-873d-a52cfdf14cac"))
//                                , new Update().push("Light",dev), "DeviceStatus");


            mongoTemplate.updateFirst(Query.query(new Criteria("type").is("hotel12") .and("date").is("2018-08-49")
                            .and("business").is("1"))
                    , new Update().push("Light",dev), "DeviceStatus");

            mongoTemplate.insert(de);
            Random random = new Random();
            int result = random.nextInt(99999);

//                       List<DeviceStatus> list =  mongoTemplate.find(Query.query(
//                                where("type").is("hotel")
//                                        .and("date").is("2018-08-49")
//                                        .and("business").is(result+"")),DeviceStatus.class,"DeviceStatus");
//                       System.out.println(JSONArray.fromObject(list).toString());
            long end = System.currentTimeMillis();

            System.out.println(i+":"+(end-start));
        }


    }

    @Test
    public void remove() {
        mongoTemplate.remove(Query.query(where("business").ne("bb545405-85b0-4243-873d-a52cfdf14cac")),"DeviceStatus");
    }

}
