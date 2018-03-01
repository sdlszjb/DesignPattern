package cn.kisslinux.soft;

import kisslinux.facade.FacadeFacade;
import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:36
 */
public class FacadeTests {

    @Test
    public void testClient() {
        FacadeFacade facade = new FacadeFacade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
