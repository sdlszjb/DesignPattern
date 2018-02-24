package cn.kisslinux.soft;

import kisslinux.builder.BuilderDirector;
import kisslinux.builder.BuilderProduct;
import org.junit.Test;

/**
 * created by lsk on 2018-02-24 22:33.
 *
 * @author 庄壮壮
 */
public class BuilderTests {

    @Test
    public void testClient() {
        BuilderDirector director = new BuilderDirector();
        BuilderProduct product = director.getAProduct();
        product.doSomething();
    }
}
