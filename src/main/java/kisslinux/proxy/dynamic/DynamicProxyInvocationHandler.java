package kisslinux.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler
 */
public class DynamicProxyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target = null;

    public DynamicProxyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     * @param proxy proxy
     * @param method method
     * @param args args
     * @return Result
     * @throws Throwable Exception
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (true) {
            (new DynamicProxyBeforeAdvice()).exec();
        }
        Object object =  method.invoke(this.target, args);

        if (true) {
            (new DynamicProxyAfterAdvice()).exec();
        }
        return object;
    }
}
