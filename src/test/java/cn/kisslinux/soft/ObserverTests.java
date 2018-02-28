package cn.kisslinux.soft;

import kisslinux.observer.ObserverConcreteObserver;
import kisslinux.observer.ObserverConcreteSubject;
import kisslinux.observer.ObserverObserver;
import org.junit.Test;

/**
 * 观察者模式测试
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:59
 */
public class ObserverTests {

    @Test
    public void testClient() {
        ObserverConcreteSubject subject = new ObserverConcreteSubject();
        ObserverObserver observer = new ObserverConcreteObserver();

        subject.addObserver(observer);
        subject.doSomething();
    }
}
