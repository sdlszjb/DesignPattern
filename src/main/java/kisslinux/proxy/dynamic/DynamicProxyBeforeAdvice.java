package kisslinux.proxy.dynamic;

/**
 * 前置通知
 */
public class DynamicProxyBeforeAdvice implements DynamicProxyAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知。");
    }
}
