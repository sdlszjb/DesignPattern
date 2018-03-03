package kisslinux.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:36
 */
public class FlyweightFactory {

    // 定义一个池对象
    private static Map<String, FlyweightFlyweight> pool = new HashMap<>();

    public static FlyweightFlyweight getFlyweight(String Extrinsic) {
        FlyweightFlyweight flyweight = null;
        if (pool.containsKey(Extrinsic)) {
            System.out.println(Extrinsic + "----直接从池中获取！");
            flyweight = pool.get(Extrinsic);
        } else {
            System.out.println(Extrinsic + "----新建，并放入池中！");
            flyweight = new FlyweightConcreteFlyweight(Extrinsic);
            pool.put(Extrinsic, flyweight);
        }

        return flyweight;
    }
}
