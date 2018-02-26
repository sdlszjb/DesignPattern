package kisslinux.mediator;

/**
 * 具体同事类 2。
 *
 * self为自处理事务
 *
 * dep为协作事务
 */
public class MediatorConcreteColleague2 extends MediatorColleague {
    private final String TAG = this.getClass().getSimpleName();

    // 通过构造函数传递中介者
    public MediatorConcreteColleague2(MediatorMediator mediator) {
        super(mediator);
    }

    // 自有方法
    public void selfMethod2() {
        System.out.println(TAG + ": selfMethod2.");
    }

    // 依赖方法
    public void depMethod2() {
        // 处理自己的业务逻辑
        // 自己不能处理的业务逻辑，委托给中介者处理
        System.out.println(TAG + ": depMethod2.");
        super.mediator.doSomething2();
    }
}
