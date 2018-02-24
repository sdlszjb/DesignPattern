package kisslinux.proxy.hard;

/**
 * created by lsk on 2018-02-24 23:48.
 *
 * @author 庄壮壮
 */
public class HardProxySubjectProxy implements HardProxySubject {

    HardProxySubject subject = null;

    public HardProxySubjectProxy(HardProxySubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    @Override
    public HardProxySubject getProxy() {
        return this;
    }

    private void before() {
        System.out.println("Something before request.");
    }

    private void after() {
        System.out.println("Something after request.");
    }
}
