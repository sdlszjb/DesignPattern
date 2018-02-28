package kisslinux.wrapper;

/**
 * 适配器
 * 将 adaptee 适配成 target
 */
public class WrapperAdapter implements WrapperTarget {

    private WrapperAdaptee adaptee;

    public WrapperAdapter(WrapperAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.doSomething();
    }
}
