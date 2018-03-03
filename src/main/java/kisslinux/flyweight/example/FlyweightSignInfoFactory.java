package kisslinux.flyweight.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:45
 */
public class FlyweightSignInfoFactory {

    private static Map<String, FlyweightSignInfo> pool = new HashMap<>();

    @Deprecated
    public static FlyweightSignInfo getSignInfo() {
        return new FlyweightSignInfo();
    }

    public static FlyweightSignInfo getSignInfo(String key) {
        FlyweightSignInfo signInfo = null;
        if (!pool.containsKey(key)) {
            System.out.println(key + "----建立对象，并放入池中！");
            signInfo = new FlyweightSignInfo4Pool(key);
            pool.put(key, signInfo);
        } else {
            signInfo = pool.get(key);
            System.out.println(key + "----直接从池中获取!");
        }
        return signInfo;
    }
}
