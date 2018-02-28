package kisslinux.wrapper;

/**
 * 具体target 目标
 */
public class WrapperConcreteTarget implements WrapperTarget {
    @Override
    public void request() {
        System.out.println("If you need any help, pls call me.");
    }
}
