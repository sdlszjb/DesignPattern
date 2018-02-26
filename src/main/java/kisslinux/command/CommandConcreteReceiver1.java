package kisslinux.command;

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
