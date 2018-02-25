package kisslinux.proxy;

public class ProxyProxyProxy implements ProxyProxy, ProxySubject {

    private ProxySubject subject = null;

    public ProxyProxyProxy(ProxySubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.proxyThing();
        this.subject.request();
    }

    @Override
    public void proxyThing() {
        System.out.println("The subject class is: " + subject);
    }
}
