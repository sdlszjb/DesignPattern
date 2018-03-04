package kisslinux.bridge.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:04
 */
public class BridgeHouseCorp extends BridgeCorp {
    public BridgeHouseCorp(BridgeHouse house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了！");
    }
}
