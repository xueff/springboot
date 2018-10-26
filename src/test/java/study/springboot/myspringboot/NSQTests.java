package study.springboot.myspringboot;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.logging.log4j.core.Core;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.myspringboot.model.protobuf.RoomStatusInfoLOuterClass;

import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NSQTests {
    @Test
    public void sendTo() {
        NSQProducer producer = new NSQProducer();
        //        ip地址和端口号
        producer.addAddress("192.168.2.206", 4150).start();
        try {
            //            topic名称、发布的消息
            producer.produce("app.qa.roomstatussync", "123".getBytes());
        } catch (NSQException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void comsumer() {
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("192.168.2.206", 4161);

        String topic = "app.qa.roomstatussync";
        NSQConsumer consumer = new NSQConsumer(lookup, topic, "channelName", (message) -> {
            if (message != null && message.getMessage() != null && message.getMessage().length > 0) {
                try {
                    byte[] by = message.getMessage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ;
        });
        consumer.start();
    }
}
