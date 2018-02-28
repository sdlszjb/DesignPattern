package kisslinux.observer;

/**
 * 具体观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:57
 */
public class ObserverConcreteObserver implements ObserverObserver {
    @Override
    public void update(ObserverSubject subject, Object dto) {
        System.out.printf("received message from :%s, message is: %s\n", subject, dto);
    }
}
