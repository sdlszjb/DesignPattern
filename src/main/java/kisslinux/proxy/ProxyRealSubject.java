package kisslinux.proxy;

/**
 * created by lsk on 2018-02-24 22:37.
 *
 * 真实主题类
 *
 * 正常的业务逻辑处理
 *
 * @author 庄壮壮
 */
public class ProxyRealSubject implements ProxySubject {
    @Override
    public void request() {
        System.out.println("this is real subject request.");
    }
}
