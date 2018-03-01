package kisslinux.facade;

/**
 * 门面对象
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:25
 */
public class FacadeFacade {

    // 被委托对象
    private FacadeClassA a = new FacadeClassA();
    private FacadeClassB b = new FacadeClassB();
    private FacadeClassC c = new FacadeClassC();

    // 提供给外部访问的方法
    public void methodA() {
        this.a.doSomethingA();
    }

    public void methodB() {
        this.b.doSomethingB();
    }

    public void methodC() {
        this.c.doSomethingC();
    }
}
