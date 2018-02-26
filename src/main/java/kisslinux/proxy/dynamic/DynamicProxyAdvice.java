package kisslinux.proxy.dynamic;

/**
 * 动态代理通知接口
 * 想要附加在业务类上的功能。
 *
 */
public interface DynamicProxyAdvice {
    public void exec();
}
