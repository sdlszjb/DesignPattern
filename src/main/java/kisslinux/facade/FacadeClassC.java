package kisslinux.facade;

/**
 * 子系统 C
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassC {
    public void doSomethingC() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}
