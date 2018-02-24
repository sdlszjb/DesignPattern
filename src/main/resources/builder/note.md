# 建造者模式

## 定义
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

```java
/**
 * created by lsk on 2018-02-24 22:07.
 * 
 * 产品类
 * 
 * @author 庄壮壮
 */
public class BuilderProduct {
    public void doSomething() {
        System.out.println("product doSomething.");
    }
}

/**
 * created by lsk on 2018-02-24 22:08.
 *
 * 抽象建造者
 * 
 * @author 庄壮壮
 */
public abstract class BuilderBuilder {
    // 设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    // 建造产品
    public abstract BuilderProduct builderProduct();
}

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

/**
 * created by lsk on 2018-02-24 22:33.
 *
 * @author 庄壮壮
 */
public class BuilderTests {

    @Test
    public void testClient() {
        BuilderDirector director = new BuilderDirector();
        BuilderProduct product = director.getAProduct();
        product.doSomething();
    }
}
```
## 优点
- 封装性。
- 建造者独立，容易扩展
- 便于控制细节风险

## 使用场景
- 相同的方法，不同的执行顺序，产生不同的事件结果，采用建造者模式。
- 多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时，采用该模式。
- 产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候采用建造者模式非常合适。

## 注意事项
- 建造者模式关注的是零件类型和装配工艺（顺序）。
- 工厂方法模式关注的时零件的产生以及产品的产生，并不关心装配的顺序。

## 扩展
- 模板方法模式。

## 最佳实践
- 若使用建造者模式，一定要考虑使用模板方法模式。