package kisslinux.bridge.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:04
 */
public class BridgeShanZhaiCorp extends BridgeCorp {
    public BridgeShanZhaiCorp(BridgeProduct product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱啦！");
    }
}
