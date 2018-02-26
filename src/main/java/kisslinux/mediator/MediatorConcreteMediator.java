package kisslinux.mediator;

/**
 * 具体中介者类。
 * 处理 同事 协作事务
 */
public class MediatorConcreteMediator extends MediatorMediator {
    private final String TAG = this.getClass().getSimpleName();
    @Override
    public void doSomething1() {
        // 调用同事类的方法
        System.out.println(TAG + ": doSomething1.");
        super.colleague1.selfMethod1();
        super.colleague2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        // 调用同事类的方法
        System.out.println(TAG + ": doSomething2.");
        super.colleague1.selfMethod1();
        super.colleague2.selfMethod2();
    }
}
