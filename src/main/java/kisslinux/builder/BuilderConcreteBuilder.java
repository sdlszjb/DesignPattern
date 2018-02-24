package kisslinux.builder;

/**
 * created by lsk on 2018-02-24 22:09.
 *
 * 具体的建造者。
 * 如果由多个产品类，就有几个具体的建造者。并且这多个产品类具有相同的接口或抽象类。
 *
 * @author 庄壮壮
 */
public class BuilderConcreteBuilder extends BuilderBuilder {

    private BuilderProduct product = new BuilderProduct();

    @Override
    public void setPart() {
        // TODO 产品类内的逻辑处理
    }

    @Override
    public BuilderProduct builderProduct() {
        return product;
    }
}
