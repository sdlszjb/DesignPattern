package cn.kisslinux.soft;

import kisslinux.decorator.DecoratorComponent;
import kisslinux.decorator.DecoratorConcreteComponent;
import kisslinux.decorator.DecoratorConcreteDecorator1;
import kisslinux.decorator.DecoratorConcreteDecorator2;
import org.junit.Test;

/**
 * created by lsk on 2018-02-27 17:25.
 *
 * @author 庄壮壮
 */
public class DecoratorTests {

    @Test
    public void testClient() {
        DecoratorComponent component = new DecoratorConcreteComponent();

        component = new DecoratorConcreteDecorator1(component);

        component = new DecoratorConcreteDecorator2(component);

        System.out.println(component.operate());
    }
}
