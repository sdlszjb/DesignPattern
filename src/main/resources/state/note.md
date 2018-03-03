# 状态模式

## 定义
当一个对象内在状态改变时，允许其改变行为，这个对象看起来像改变类其类。

### 标准接口
```java
/**
 * created by lsk on 2018-03-02 16:38.
 *
 * 抽象状态角色
 *
 * @author 庄壮壮
 */
public abstract class StateState {

    // 定义一个环境角色，提供子类访问
    protected StateContext context;

    // 设置环境角色
    public void setContext(StateContext context) {
        this.context = context;
    }

    // 行为
    public abstract void handle1();
    public abstract void handle2();
}

/**
 * created by lsk on 2018-03-02 16:39.
 *
 * 具体状态类 1
 *
 * @author 庄壮壮
 */
public class StateConcreteState1 extends StateState {
    @Override
    public void handle1() {
        // 本状态下必须处理的逻辑
        System.out.println("Running " + this.getClass().getName() + ", Mehtod: " + new Exception().getStackTrace()[0].getMethodName());
    }

    @Override
    public void handle2() {
        // 设置当前状态为state2
        super.context.setCurrentState(StateContext.STATE2);
        // 过渡到state2状态，由Context实现
        super.context.handle2();
    }
}

/**
 * created by lsk on 2018-03-02 16:39.
 *
 * 具体状态类 2
 *
 * @author 庄壮壮
 */
public class StateConcreteState2 extends StateState {
    @Override
    public void handle1() {
        // 设置当前状态为state1
        super.context.setCurrentState(StateContext.STATE1);
        // 过渡到state1状态，由Context实现
        super.context.handle1();
    }

    @Override
    public void handle2() {
        // 本状态下必须处理的逻辑
        System.out.println("Running " + this.getClass().getName() + ", Mehtod: " + new Exception().getStackTrace()[0].getMethodName());
    }
}

/**
 * created by lsk on 2018-03-02 16:43.
 * 环境角色
 * @author 庄壮壮
 */
public class StateContext {
    // 定义状态
    public static final StateState STATE1 = new StateConcreteState1();
    public static final StateState STATE2 = new StateConcreteState2();

    // 当前状态
    private StateState currentState;

    // 设置当前的状态
    public void setCurrentState(StateState currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    // 行为委托
    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
```
## 应用
### 优点
- 结构清晰
- 遵循设计原则
- 封装性非常好

### 缺点
- 子类太多

### 使用场景
- 行为随状态改变而改变的场景
如权限设计，人员的状态不同，即使执行相同的行为，结果也会不同，这种情况考虑使用状态模式。
- 条件、分支判断语句的替代者
大量使用switch或者if会导致程序结构不清晰，考虑使用状态模式

### 注意事项
- 状态模式适合，对象的状态发生改变时，其行为也发生改变，也就是行为受状态约束的情况下可以使用状态模式。

### 最佳实践
- 状态机
- 建造者和状态模式混用会起到非常好的封装作用

### example
```java


/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:29
 */
public abstract class StateLiftState {
    protected StateLiftContext context;

    public void setContext(StateLiftContext context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:30
 */
public class StateLiftContext {
    public final static StateOpeningState openingState = new StateOpeningState();
    public final static StateClosingState closingState = new StateClosingState();
    public final static StateRunningState runningState = new StateRunningState();
    public final static StateStoppingState stopingState = new StateStoppingState();

    private StateLiftState liftState;

    public StateLiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(StateLiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateOpeningState extends StateLiftState {
    @Override
    public void open() {
        System.out.println("电梯开启中...");
        System.out.println("电梯开启成功！");
    }

    @Override
    public void close() {
        super.context.setLiftState(StateLiftContext.closingState);
        super.context.close();
    }

    @Override
    public void run() {
        System.out.println("什么也不做！");
    }

    @Override
    public void stop() {
        System.out.println("什么也不做！");
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateClosingState extends StateLiftState {
    @Override
    public void open() {
        super.context.setLiftState(StateLiftContext.openingState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯关闭中...");
        System.out.println("电梯关闭成功！");
    }

    @Override
    public void run() {
        super.context.setLiftState(StateLiftContext.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("什么也做！");
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateRunningState extends StateLiftState {
    @Override
    public void open() {
        System.out.println("什么也不做！");
    }

    @Override
    public void close() {
        System.out.println("什么也不做！");
    }

    @Override
    public void run() {
        System.out.println("电器启动中...");
        System.out.println("电器运行成功！");
    }

    @Override
    public void stop() {
        super.context.setLiftState(StateLiftContext.stopingState);
        super.context.stop();
    }
}


/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateStoppingState extends StateLiftState {
    @Override
    public void open() {
        super.context.setLiftState(StateLiftContext.openingState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("什么也不做！");
    }

    @Override
    public void run() {
        super.context.setLiftState(StateLiftContext.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止中...");
        System.out.println("电梯停止成功！");
    }
}

/**
 * created by lsk on 2018-03-02 16:52.
 *
 * @author 庄壮壮
 */
public class StateTests {

    @Test
    public void testExample() {
        StateLiftContext context = new StateLiftContext();
        context.setLiftState(StateLiftContext.closingState);

        context.open();
        context.close();
        context.open();
        context.run();
        context.stop();
        context.close();
        context.run();
        context.stop();
        context.run();
        context.stop();
        context.open();
    }
}
```


