package kisslinux.facade;

/**
 * 子系统 A
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassA {
    public void doSomethingA() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}
