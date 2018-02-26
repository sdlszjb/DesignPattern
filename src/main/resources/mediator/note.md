# 中介者模式

## 定义
用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地交互，从而使其耦合松散，而且可以独立地改变他们之间的交互。

```java

/**
 * 同事类接口
 *
 * 以构造函数注入中介者
 */
public abstract class MediatorColleague {
    protected MediatorMediator mediator;

    public MediatorColleague(MediatorMediator mediator) {
        this.mediator = mediator;
    }
}

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

/**
 * 抽象中介者类
 */
public abstract class MediatorMediator {

    // 定义同事类
    protected MediatorConcreteColleague1 colleague1;
    protected MediatorConcreteColleague2 colleague2;

    public MediatorConcreteColleague1 getColleague1() {
        return colleague1;
    }

    public void setColleague1(MediatorConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public MediatorConcreteColleague2 getColleague2() {
        return colleague2;
    }

    public void setColleague2(MediatorConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public abstract void doSomething1();
    public abstract void doSomething2();
}

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

/**
 * 中介者模式测试类
 */
public class MediatorTests {

    @Test
    public void testClient() {
        MediatorMediator mediator = new MediatorConcreteMediator();
        MediatorConcreteColleague1 colleague1 = new MediatorConcreteColleague1(mediator);
        MediatorConcreteColleague2 colleague2 = new MediatorConcreteColleague2(mediator);
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        System.out.println("---- doSomething1 ----");
        mediator.doSomething1();

        System.out.println("---- doSomething2 ----");
        mediator.doSomething2();

        System.out.println("---- depMethod1 ----");
        colleague1.depMethod1();

        System.out.println("---- depMethod2 ----");
        colleague2.depMethod2();

    }
}
```

## 优点
- 减少类间依赖，把原有的一对多依赖变成一对一依赖。同事类只依赖中介者，降低耦合。

## 缺点
- 中介者类膨胀，逻辑复杂。同事类越多，逻辑越复杂

## 使用场景
- 在类图中出现了蛛网状结构，可以考虑使用中介者

## 实际应用
- 机场调度
- MVC
- MVP
- 媒体网关
- 中介服务

## 最佳实践
- 对象相互依赖，N>2
- 多个对象有依赖关系
- 产品开发
