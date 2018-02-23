package kisslinux.singletonPattern;

/**
 * 线程不安全
 */
public class NotThreadSafeSingleton {
    private NotThreadSafeSingleton() {
    }

    private static NotThreadSafeSingleton notThreadSafeSingleton = null;

    public static NotThreadSafeSingleton getSingleton() {
        if (notThreadSafeSingleton == null) {
            notThreadSafeSingleton = new NotThreadSafeSingleton();
        }
        return notThreadSafeSingleton;
    }

    /**
     * 线程安全的
     * 懒汉
     * @return NotThreadSafeSingleton
     */
    public static synchronized NotThreadSafeSingleton getThreadSafeSingleton() {
        if (notThreadSafeSingleton == null) {
            notThreadSafeSingleton = new NotThreadSafeSingleton();
        }
        return notThreadSafeSingleton;
    }
}
