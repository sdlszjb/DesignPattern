package kisslinux.singletonPattern;

public class NotThreadSafeSingleton {
    private NotThreadSafeSingleton() {
    }

    private static NotThreadSafeSingleton notThreadSafeSingleton = null;

    public static NotThreadSafeSingleton getSingleton() {
        if (notThreadSafeSingleton == null) {
            return new NotThreadSafeSingleton();
        }
        return notThreadSafeSingleton;
    }
}
