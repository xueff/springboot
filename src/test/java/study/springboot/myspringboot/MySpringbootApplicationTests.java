package study.springboot.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.myspringboot.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootApplicationTests {
    @Autowired
    Person p;
    @Test
    public void contextLoads() {
        System.out.println(p);
    }

}
