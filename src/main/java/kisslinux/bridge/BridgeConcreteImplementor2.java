package kisslinux.bridge;

/**
 * 具体实现化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:39
 */
public class BridgeConcreteImplementor2 implements BridgeImplementor {
    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + ": doSomething.");
    }

    @Override
    public void doAnything() {
        System.out.println(this.getClass().getName() + ": doAnything.");
    }
}
