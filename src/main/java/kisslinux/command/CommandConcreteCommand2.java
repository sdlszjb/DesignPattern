package kisslinux.command;

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
