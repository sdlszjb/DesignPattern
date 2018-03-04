package kisslinux.bridge;

/**
 * 修正抽象化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:39
 */
public class BridgeRefinedAbstraction extends BridgeAbstraction {
    public BridgeRefinedAbstraction(BridgeImplementor implementor) {
        super(implementor);
    }

    @Override
    public void request() {
        super.request();
        super.getImplementor().doAnything();
    }
}
