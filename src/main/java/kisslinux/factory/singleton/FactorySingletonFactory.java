package kisslinux.factory.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例工厂
 */
public class FactorySingletonFactory {

    private static FactorySingleton singleton;

    static {
        try {
            // Class c = Class.forName(FactorySingleton.class.getName());
            Class<?> c = FactorySingleton.class;

            // 获得无参构造函数
            Constructor constructor = c.getDeclaredConstructor();
            // 设置无参构造函数是可访问的
            constructor.setAccessible(true);

            // 产生一个实例对象
            singleton = (FactorySingleton) constructor.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static FactorySingleton getSingleton() {
        return singleton;
    }
}
