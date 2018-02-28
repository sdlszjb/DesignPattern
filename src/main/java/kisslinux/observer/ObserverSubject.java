package kisslinux.observer;

import java.util.Vector;

/**
 * 被观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:51
 */
public abstract class ObserverSubject {

    // 定义一个观察者数组
    private Vector<ObserverObserver> observers = new Vector<>();

    // 增加一个观察者
    public void addObserver(ObserverObserver observer) {
        this.observers.add(observer);
    }

    // 删除一个观察者
    public void delObserver(ObserverObserver observer) {
        this.observers.remove(observer);
    }

    // 通知所有观察者
    public void notifyObservers(ObserverSubject subject, Object dto) {
        for (ObserverObserver observer : this.observers) {
            observer.update(subject, dto);
        }
    }
}
