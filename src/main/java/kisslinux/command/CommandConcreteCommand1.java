package kisslinux.command;

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
