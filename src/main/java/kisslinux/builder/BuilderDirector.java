package kisslinux.builder;

/**
 * created by lsk on 2018-02-24 22:12.
 *
 * 导演类
 * 在建造者模式比较庞大时，导演类可以有多个。
 *
 * @author 庄壮壮
 */
public class BuilderDirector {
    private BuilderBuilder builder = new BuilderConcreteBuilder();

    // 构建不同的产品
    public BuilderProduct getAProduct() {
        builder.setPart();
        /**
         * 设置不同的零件，产生不同的产品
         */
        return builder.builderProduct();
    }
}
