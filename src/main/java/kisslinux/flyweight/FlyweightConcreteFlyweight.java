package kisslinux.flyweight;

/**
 * 具体享元角色
 * 该角色应当与外界环境无关
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:34
 */
public class FlyweightConcreteFlyweight extends FlyweightFlyweight {

    // 接受外部状态
    public FlyweightConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    /**
     * 根据外部状态进行逻辑处理
     */
    @Override
    public void operate() {
        // 业务逻辑
    }
}
