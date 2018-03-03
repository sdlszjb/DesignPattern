package kisslinux.flyweight;

/**
 * 抽象享元角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:34
 */
public abstract class FlyweightFlyweight {

    // 内部状态
    private String intrinsic;

    // 外部状态
    protected final String Extrinsic;

    // 要求享元角色必须接受外部状态
    public FlyweightFlyweight(String extrinsic) {
        Extrinsic = extrinsic;
    }

    // 定义业务操作
    public abstract void operate();

    // 内部状态getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
