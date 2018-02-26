package kisslinux.command;

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
