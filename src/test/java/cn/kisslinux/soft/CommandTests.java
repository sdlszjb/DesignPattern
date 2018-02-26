package cn.kisslinux.soft;

import kisslinux.command.*;
import org.junit.Test;

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
