package pk.absfactoryVSbuilder.absfactory;

import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:56
 */
public class Client {

    @Test
    public void testClient() {
        System.out.println("=== 生产 奔驰 SUV ===");
        CarFactory benFactory = new BenzFactory();
        Car benzSUV = benFactory.createSUV();

        System.out.println(benzSUV.getBand());
        System.out.println(benzSUV.getModel());
    }
}
