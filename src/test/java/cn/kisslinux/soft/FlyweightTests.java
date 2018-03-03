package cn.kisslinux.soft;

import kisslinux.flyweight.FlyweightFactory;
import kisslinux.flyweight.FlyweightFlyweight;
import kisslinux.flyweight.example.FlyweightSignInfo;
import kisslinux.flyweight.example.FlyweightSignInfoFactory;
import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:51
 */
public class FlyweightTests {

    @Test
    public void testClient() {
        for (int i=0; i<10; i++) {
            FlyweightFactory.getFlyweight("key:"+i);
        }
        FlyweightFlyweight flyweight = FlyweightFactory.getFlyweight("key:5");
        flyweight.operate();
    }

    @Test
    public void testExample() {
        for (int i=0; i<4; i++) {
            String subject = "科目：" + i;
            for (int j = 0; j<30; j++) {
                String key = subject + "考试地点：" + j;
                FlyweightSignInfoFactory.getSignInfo(key);
            }
        }

        FlyweightSignInfo signInfo = FlyweightSignInfoFactory.getSignInfo("科目：1考试地点：1");
    }
}
