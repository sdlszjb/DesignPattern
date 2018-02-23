package kisslinux.singletonPattern;

/**
 * 线程安全
 * 饿汉
 */
public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton threadSafeSingleton = new ThreadSafeSingleton();

    // 限制实例化
    private ThreadSafeSingleton() {
    }

    // 获取实例对象
    public static ThreadSafeSingleton getSingleton() {
        return threadSafeSingleton;
    }
}
