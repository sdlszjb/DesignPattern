package kisslinux.observer;

/**
 * 具体被观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:56
 */
public class ObserverConcreteSubject extends ObserverSubject {

    public void doSomething() {
        /**
         * do something.
         */
        System.out.println("subject doSomething.");
        super.notifyObservers(this, this.getClass().getSimpleName());
    }
}
