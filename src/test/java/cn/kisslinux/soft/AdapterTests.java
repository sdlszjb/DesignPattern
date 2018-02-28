package cn.kisslinux.soft;

import kisslinux.wrapper.*;
import org.junit.Test;

public class AdapterTests {

    @Test
    public void testClient() {
        WrapperAdaptee adaptee = new WrapperConcreteAdaptee();
        WrapperTarget target = new WrapperAdapter(adaptee);

        // Adapter适配后的target
        target.request();

        // 主动产生的target
        WrapperTarget concreteTarget = new WrapperConcreteTarget();
        concreteTarget.request();
    }
}
