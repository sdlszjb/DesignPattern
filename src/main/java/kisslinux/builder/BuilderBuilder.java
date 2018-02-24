package kisslinux.builder;

/**
 * created by lsk on 2018-02-24 22:08.
 *
 * @author 庄壮壮
 */
public abstract class BuilderBuilder {
    // 设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    // 建造产品
    public abstract BuilderProduct builderProduct();
}
