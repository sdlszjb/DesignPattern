package pk.factoryVSbuilder.factory;

import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:22
 */
public class FactoryTests {

    @Test
    public void testClient() {
        SuperMan adultSuperMan = SuperManFactory.createSuperMan("adult");
        if (adultSuperMan != null) {
            adultSuperMan.specialTalent();
        }
    }
}
