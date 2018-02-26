package kisslinux.mediator;

/**
 * 具体同事类 1。
 *
 * self为自处理事务
 *
 * dep为协作事务
 */
public class MediatorConcreteColleague1 extends MediatorColleague {
    private final String TAG = this.getClass().getSimpleName();

    // 通过构造函数传递中介者
    public MediatorConcreteColleague1(MediatorMediator mediator) {
        super(mediator);
    }

    // 自有方法
    public void selfMethod1() {
        System.out.println(TAG + ": selfMethod1.");
    }

    // 依赖方法
    public void depMethod1() {
        // 处理自己的业务逻辑
        // 自己不能处理的业务逻辑，委托给中介者处理
        System.out.println(TAG + ": depMethod1.");
        super.mediator.doSomething1();
    }
}
