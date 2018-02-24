package cn.kisslinux.soft;

import kisslinux.template.TemplateAbstractClass;
import kisslinux.template.TemplateConcreteClass1;
import kisslinux.template.TemplateConcreteClass2;
import org.junit.Test;

/**
 * created by lsk on 2018-02-24 17:50.
 *
 * @author 庄壮壮
 */
public class TemplateTests {

    @Test
    public void testClient() {
        TemplateAbstractClass c1 = new TemplateConcreteClass1();
        TemplateAbstractClass c2 = new TemplateConcreteClass2();

        c1.templateMethod();
        c2.templateMethod();
    }
}
