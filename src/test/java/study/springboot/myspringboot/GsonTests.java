package study.springboot.myspringboot;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.myspringboot.bean.RoomStatusSyncConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GsonTests {
    @Test
    public void jsonStringToModel() throws IOException {

        ClassPathResource resource = new ClassPathResource("BootVideo.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }

        System.out.println(message.toString());
        JsonObject returnData = new JsonParser().parse(message.toString()).getAsJsonObject();
        RoomStatusSyncConfig model = new Gson().fromJson(returnData,RoomStatusSyncConfig.class);
        System.out.println(model.getNsqAdminUrl());

    }

    @Test
    public void stringToMap(){

        String jsonString = "";
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        String goodsid=(String) map.get("goods_id");
        System.out.println("map的值为:"+goodsid);
    }

    public static void main(String[] args) {
        Gson gson = new Gson();

        RoomStatusSyncConfig student1 = new RoomStatusSyncConfig();
        student1.setNsqAdminUrl("hh");

        // //////////////////////////////////////////////////////////
        System.out.println("----------简单对象之间的转化-------------");
        // 简单的bean转为json
        String s1 = gson.toJson(student1);
        System.out.println("简单Bean转化为Json===" + s1);

        // json转为简单Bean
        RoomStatusSyncConfig student = gson.fromJson(s1, RoomStatusSyncConfig.class);
        System.out.println("Json转为简单Bean===" + student);
        // 结果:
        // 简单Bean转化为Json==={"id":1,"name":"李坤","birthDay":"Jun 22, 2012 8:27:52 AM"}
        // Json转为简单Bean===Student [birthDay=Fri Jun 22 08:27:52 CST 2012, id=1,
        // name=李坤]
        // //////////////////////////////////////////////////////////

        RoomStatusSyncConfig student2 = new RoomStatusSyncConfig();
        student2.setNsqAdminUrl("r");


        RoomStatusSyncConfig student3 = new RoomStatusSyncConfig();
        student3.setNsqAdminUrl("r");
        List<RoomStatusSyncConfig> list = new ArrayList<RoomStatusSyncConfig>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        System.out.println("----------带泛型的List之间的转化-------------");
        // 带泛型的list转化为json
        String s2 = gson.toJson(list);
        System.out.println("带泛型的list转化为json==" + s2);

        // json转为带泛型的list
        List<RoomStatusSyncConfig> retList = gson.fromJson(s2,
                new TypeToken<List<RoomStatusSyncConfig>>() {
                }.getType());
        for (RoomStatusSyncConfig stu : retList) {
            System.out.println(stu);
        }

        // 结果:
        // 带泛型的list转化为json==[{"id":1,"name":"李坤","birthDay":"Jun 22, 2012 8:28:52 AM"},{"id":2,"name":"曹贵生","birthDay":"Jun 22, 2012 8:28:52 AM"},{"id":3,"name":"柳波","birthDay":"Jun 22, 2012 8:28:52 AM"}]
        // Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=1, name=李坤]
        // Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=2, name=曹贵生]
        // Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=3, name=柳波]

    }

    @Test
    public void createJson(){
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("action","tvyuyin.channeldataupdate");
        jsonObj.addProperty("timestamp",new java.util.Date().getTime());
        jsonObj.addProperty("Key",UUID.randomUUID()+"");
        JsonObject jsonObj2 = new JsonObject();
        jsonObj2.addProperty("child","child");
        jsonObj.add("data",jsonObj2);

        System.out.println(new Gson().toJson(jsonObj));
    }


    @Test
    public void test(){
        Set<String> gateMessage = new HashSet<String>();
        gateMessage.add("as");
        gateMessage.add("as1");
        String[] sy =  gateMessage.toArray(new String[gateMessage.size()]);
        System.out.println(Arrays.toString(sy));

        gateMessage = new HashSet<String>();

        sy = (String[]) gateMessage.toArray();
        System.out.println(Arrays.toString(sy));
    }

    @Test
    public void  getKey(){
        JsonObject jsonObj = new JsonObject();
        com.google.gson.JsonObject info = jsonObj.getAsJsonObject("props");

    }


}
