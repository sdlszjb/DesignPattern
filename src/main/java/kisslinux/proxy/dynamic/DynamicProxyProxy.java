package kisslinux.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 通用 目标对象代理对象获取工具
 * @param <T>
 */
public class DynamicProxyProxy<T> {

    /**
     * 获取目标对象的代理对象
     * @param loader ClassLoader
     * @param interfaces interfaces
     * @param handler InvocationHandler
     * @param <T> T
     * @return proxy
     */
    @SuppressWarnings("unchecked")
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }
}
