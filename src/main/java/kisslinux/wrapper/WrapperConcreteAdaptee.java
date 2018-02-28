package kisslinux.wrapper;

/**
 * 具体adaptee 源
 */
public class WrapperConcreteAdaptee implements WrapperAdaptee {
    @Override
    public void doSomething() {
        System.out.println("I'm kind of busy, leave me alone, pls!");
    }
}
