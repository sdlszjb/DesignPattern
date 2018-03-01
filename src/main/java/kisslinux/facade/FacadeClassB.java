package kisslinux.facade;

/**
 * 子系统 B
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassB {
    public void doSomethingB() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}
