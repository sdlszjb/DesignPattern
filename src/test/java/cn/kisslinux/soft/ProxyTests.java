package cn.kisslinux.soft;

import kisslinux.proxy.ProxyProxyProxy;
import kisslinux.proxy.ProxyRealSubject;
import kisslinux.proxy.ProxySubject;
import kisslinux.proxy.ProxySubjectProxy;
import kisslinux.proxy.dynamic.*;
import kisslinux.proxy.hard.HardProxyRealSubject;
import kisslinux.proxy.hard.HardProxySubject;
import kisslinux.proxy.hard.HardProxySubjectProxy;
import org.junit.Test;

/**
 * created by lsk on 2018-02-24 22:44.
 *
 * @author 庄壮壮
 */
public class ProxyTests {

    @Test
    public void testClient() {
        ProxySubject subject = new ProxySubjectProxy(new ProxyRealSubject());
        subject.request();
    }

    @Test
    public void testHardClient() {

        HardProxySubject subject = new HardProxyRealSubject();

        System.out.println("-------\n" +
                "ReadSubject: \n" +
                "-------");
        subject.request();

        System.out.println();
        System.out.println();

        HardProxySubject proxy = new HardProxySubjectProxy(new HardProxyRealSubject());
        System.out.println("-------\n" +
                "MyProxy: \n" +
                "-------");
        proxy.request();


        System.out.println();
        System.out.println();

        System.out.println("-------\n" +
                "RealProxy: \n" +
                "-------");
        HardProxySubject realSub = new HardProxyRealSubject();
        HardProxySubject realProxy = realSub.getProxy();
        realProxy.request();
    }

    /**
     * 测试 Proxy接口，定制Proxy特性。
     */
    @Test
    public void testProxyInterface() {
        ProxySubject subject = new ProxyProxyProxy(new ProxyRealSubject());
        subject.request();
    }

    @Test
    public void testDynamicProxy() {
        DynamicProxySubject subject = new DynamicProxyRealSubject();
        DynamicProxySubject proxy = DynamicProxySubjectProxy.newProxyInstance(subject);
        proxy.doSomething();
    }
}
