package pk.factoryVSbuilder.builder;

import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:31
 */
public class Client {

    @Test
    public void testClient() {
        SuperMan superMan = Director.getAdultSuperMan();
        System.out.println(superMan.getSpecialTalent());
    }
}
