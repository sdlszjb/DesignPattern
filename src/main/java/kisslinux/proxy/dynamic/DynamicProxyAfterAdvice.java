package kisslinux.proxy.dynamic;

/**
 * 后置通知
 */
public class DynamicProxyAfterAdvice implements DynamicProxyAdvice {
    @Override
    public void exec() {
        System.out.println("我是后置通知！");
    }
}
