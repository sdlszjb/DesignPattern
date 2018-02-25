package kisslinux.proxy.dynamic;

public class DynamicProxyRealSubject implements DynamicProxySubject {
    @Override
    public String doSomething() {
        System.out.println("Running from real subject.");
        return "I'm real subject.";
    }
}
