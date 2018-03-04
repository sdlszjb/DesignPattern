package kisslinux.bridge.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:02
 */
public abstract class BridgeCorp {
    private BridgeProduct product;

    public BridgeCorp(BridgeProduct product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.beProducted();
        this.product.beSelled();
    }
}
