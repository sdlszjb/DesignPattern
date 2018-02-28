package kisslinux.observer;

/**
 * 观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:52
 */
public interface ObserverObserver {
    public void update(ObserverSubject subject, Object dto);
}
