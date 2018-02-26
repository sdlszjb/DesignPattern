# 命令模式

## 定义
将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或记录请求日志，可以提供命令的撤销和恢复功能。

```java
/**
 * 命令执行者
 */
public abstract class CommandReceiver {

    public abstract void doSomething();
}

/**
 * 具体命令执行者
 */
public class CommandConcreteReceiver1 extends CommandReceiver {
    private final String TAG = this.getClass().getName();
    @Override
    public void doSomething() {
        System.out.println(TAG + ": reveiver1 doSomething.");
    }
}

/**
 * 抽象命令接口
 */
public abstract class CommandCommand {
    public abstract void execute();
}

/**
 * 具体命令 1
 */
public class CommandConcreteCommand1 extends CommandCommand {

    // 命令的具体执行者
    private CommandReceiver receiver;

    // 构造函数传递接受者
    public CommandConcreteCommand1(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    // 必须实现一个命令
    @Override
    public void execute() {
        // 具体业务处理
        this.receiver.doSomething();
    }
}

/**
 * 具体命令 2
 */
public class CommandConcreteCommand2 extends CommandCommand {

    // 命令的具体执行者
    private CommandReceiver receiver;

    // 构造函数传递接受者
    public CommandConcreteCommand2(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    // 必须实现一个命令
    @Override
    public void execute() {
        // 具体业务处理
        this.receiver.doSomething();
    }
}

/**
 * Command的包装类
 */
public class CommandInvoker {
    private CommandCommand command;

    // 接收命令
    public void setCommand(CommandCommand command) {
        this.command = command;
    }

    // 执行命令
    public void action() {
        this.command.execute();
    }
}

/**
 * 使用场景类
 *
 * 实际使用过程可以进行扩展，例如对Command的扩展，隐藏Receiver层。
 *
 */
public class CommandTests {

    @Test
    public void testClient() {
        CommandInvoker invoker = new CommandInvoker();
        CommandReceiver receiver = new CommandConcreteReceiver1();
        CommandCommand command1 = new CommandConcreteCommand1(receiver);

        invoker.setCommand(command1);
        invoker.action();

        CommandCommand command2 = new CommandConcreteCommand2(receiver);
        invoker.setCommand(command2);
        invoker.action();
    }
}
```

## 优点
- 类间解耦
调用者和接收者之间没有任何依赖关系。调用者实现功能时只需要调用Command抽象类的execute方法，不需要了解到底哪个接收者执行。

- 可扩展性
Command子类可以非常容易扩展，调用者Invoker和高层次模块Client不产生严重代码耦合。

- 命令模式结合其他模式更优秀
可结合责任链模式，实现命令族解析任务；结合模板方法模式，可减少Command子类膨胀问题。

## 缺点
- Command子类数量大。

## 使用场景
- GUI的点击事件处理
- 命令行
- 触发反馈

## 扩展
命令层对执行者进行封装，一个命令可以有多个执行者进行。（PS. 一种中介？)

## 反悔
记录操作日志，可进行事务回滚。

## 最佳实践
在实际应用中，一般会将Receiver层封装掉，以减少高层（Client）对底层模块（Receiver）的依赖，提高系统的稳定性。