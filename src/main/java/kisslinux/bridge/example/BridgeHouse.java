package kisslinux.bridge.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:00
 */
public class BridgeHouse extends BridgeProduct {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}
