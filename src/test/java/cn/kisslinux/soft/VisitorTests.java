package cn.kisslinux.soft;

import kisslinux.visitor.VisitorConcreteVisitor;
import kisslinux.visitor.VisitorElement;
import kisslinux.visitor.VisitorObjectStructure;
import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:20
 */
public class VisitorTests {

    @Test
    public void testClient() {
        for (int i = 0; i < 10; i++) {
            VisitorElement element = VisitorObjectStructure.createElement();
            element.accept(new VisitorConcreteVisitor());
        }
    }
}
