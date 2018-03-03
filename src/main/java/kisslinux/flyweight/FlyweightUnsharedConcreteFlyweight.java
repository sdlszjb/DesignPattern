package kisslinux.flyweight;

/**
 * 不可共享的享元角色
 *
 * 该对象不存在外部状态或者安全要求（如线程安全），不能使用共享技术的对象
 * 该对象一般不会出现在享元工厂中。
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:34
 */
public class FlyweightUnsharedConcreteFlyweight extends FlyweightFlyweight {
    public FlyweightUnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    /**
     * 根据外部状态进行逻辑处理
     */
    @Override
    public void operate() {

    }
}
