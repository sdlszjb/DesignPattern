package cn.kisslinux.soft;

import kisslinux.mediator.MediatorConcreteColleague1;
import kisslinux.mediator.MediatorConcreteColleague2;
import kisslinux.mediator.MediatorConcreteMediator;
import kisslinux.mediator.MediatorMediator;
import org.junit.Test;

/**
 * 中介者模式测试类
 */
public class MediatorTests {

    @Test
    public void testClient() {
        MediatorMediator mediator = new MediatorConcreteMediator();
        MediatorConcreteColleague1 colleague1 = new MediatorConcreteColleague1(mediator);
        MediatorConcreteColleague2 colleague2 = new MediatorConcreteColleague2(mediator);
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        System.out.println("---- doSomething1 ----");
        mediator.doSomething1();

        System.out.println("---- doSomething2 ----");
        mediator.doSomething2();

        System.out.println("---- depMethod1 ----");
        colleague1.depMethod1();

        System.out.println("---- depMethod2 ----");
        colleague2.depMethod2();

    }
}
