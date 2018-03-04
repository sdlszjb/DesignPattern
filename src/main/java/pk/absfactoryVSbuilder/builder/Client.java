package pk.absfactoryVSbuilder.builder;

import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:30
 */
public class Client {

    @Test
    public void testClient() {
        Director director =new Director();
        System.out.println("===制造一辆奔驰SUV===");
        ICar benzSuv = director.createBenzSUV();
        System.out.println(benzSuv);

        System.out.println("\n===制造一辆宝马商务车===");
        ICar bmwVan = director.createBMWVan();
        System.out.println(bmwVan);

        System.out.println("\n===制造一辆混合车===");
        ICar complexCar = director.createComplexCar();
        System.out.println(complexCar);
    }
}
