package kisslinux.bridge.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:02
 */
public class BridgeIpod extends BridgeProduct {
    @Override
    public void beProducted() {
        System.out.println("生产出的IPod是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的IPod卖出去了...");
    }
}
