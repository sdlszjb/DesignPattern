package cn.kisslinux.soft;

import kisslinux.absfactory.*;
import org.junit.Test;

public class AbsFactoryTests {

    @Test
    public void testClient() {
        AbsFactoryCreator creator1 = new AbsFactoryCreator1();
        AbsFactoryCreator creator2 = new AbsFactoryCreator2();

        AbsFactoryProductA productA1 = creator1.createProductA();
        AbsFactoryProductB productB1 = creator1.createProductB();
        AbsFactoryProductA productA2 = creator2.createProductA();
        AbsFactoryProductB productB2 = creator2.createProductB();

        productA1.doSomething();
        productA2.doSomething();
        productB1.doSomething();
        productB2.doSomething();
    }
}
