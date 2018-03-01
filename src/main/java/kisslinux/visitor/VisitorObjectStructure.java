package kisslinux.visitor;

import java.util.Random;

/**
 * 模拟 数据获取
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:15
 */
public class VisitorObjectStructure {
    public static VisitorElement createElement() {
        Random random = new Random();
        int age = random.nextInt(100);
        if (age > 50) {
            return new VisitorConcreteElement1("big", age);
        } else {
            return new VisitorConcreteElement2("small", age);
        }
    }
}
