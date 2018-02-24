package kisslinux.proxy;

/**
 * created by lsk on 2018-02-24 22:38.
 *
 * @author 庄壮壮
 */
public class ProxySubjectProxy implements ProxySubject {

    // 要代理的实现类
    private ProxySubject subject = null;

    // 默认被代理者
    public ProxySubjectProxy() {
        this .subject = new ProxySubjectProxy();
    }

    // 通过构造函数传递代理者
    public ProxySubjectProxy(ProxySubject _subject) {
        this.subject = _subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    // 预处理
    private void before() {
        System.out.println("Something before request from proxy.");
    }

    // 后处理
    private void after() {
        System.out.println("Something after request from proxy.");
    }
}
