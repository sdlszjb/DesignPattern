package kisslinux.proxy.dynamic;

public class DynamicProxyAfterAdvice implements DynamicProxyAdvice {
    @Override
    public void exec() {
        System.out.println("我是后置通知！");
    }
}
