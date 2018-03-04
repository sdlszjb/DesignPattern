package kisslinux.bridge;

/**
 * 抽象化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:19
 */
public abstract class BridgeAbstraction {
    // 定义对实现化角色的引用
    private BridgeImplementor implementor;

    // 约束子类必须实现该构造函数
    public BridgeAbstraction(BridgeImplementor implementor) {
        this.implementor = implementor;
    }

    // 自身的行为和属性
    public void request() {
        this.implementor.doSomething();
    }

    // 获得实现化角色
    public BridgeImplementor getImplementor() {
        return implementor;
    }
}
