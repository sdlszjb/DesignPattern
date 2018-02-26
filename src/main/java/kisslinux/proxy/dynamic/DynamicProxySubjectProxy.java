package kisslinux.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

/**
 * created by lsk on 2018-02-26 17:22.
 *
 * 针对DynamicProxySubject的封装
 * 让上层调用更简单。
 *
 * @author 庄壮壮
 */
public class DynamicProxySubjectProxy extends DynamicProxyProxy<DynamicProxySubject> {
    public static <T> T newProxyInstance (DynamicProxySubject subject) {
        ClassLoader loader = subject.getClass().getClassLoader();
        Class<?>[] classes = subject.getClass().getInterfaces();
        InvocationHandler handler = new DynamicProxyInvocationHandler(subject);

        return newProxyInstance(loader, classes, handler);
    }
}
