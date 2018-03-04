package cn.kisslinux.soft;

import kisslinux.bridge.example.BridgeHouse;
import kisslinux.bridge.example.BridgeHouseCorp;
import kisslinux.bridge.example.BridgeIpod;
import kisslinux.bridge.example.BridgeShanZhaiCorp;
import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 11:58
 */
public class BridgeTests {

    @Test
    public void testClient() {

    }

    @Test
    public void testExample() {
        BridgeHouse house = new BridgeHouse();
        System.out.println("--- 房地产公司 ---");
        BridgeHouseCorp houseCorp = new BridgeHouseCorp(house);
        houseCorp.makeMoney();

        System.out.println();

        System.out.println("--- 山寨公司 ---");
        BridgeShanZhaiCorp shanZhaiCorp = new BridgeShanZhaiCorp(new BridgeIpod());
        shanZhaiCorp.makeMoney();
    }
}
