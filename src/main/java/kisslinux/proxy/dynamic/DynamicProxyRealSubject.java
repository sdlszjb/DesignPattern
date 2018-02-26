package kisslinux.proxy.dynamic;

/**
 * 一个普通的业务类型接口的实现
 */
public class DynamicProxyRealSubject implements DynamicProxySubject {
    @Override
    public String doSomething() {
        System.out.println("Running from real subject.");
        return "I'm real subject.";
    }
}
