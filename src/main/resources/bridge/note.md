# 桥梁模式

## 定义
桥梁模式也叫作桥接模式。将抽象和实现解耦，使得两者可以独立地变化。
```java
/**
 * 抽象化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:19
 */
public abstract class BridgeAbstraction {
    // 定义对实现化角色的引用
    private BridgeImplementor implementor;

    // 约束子类必须实现该构造函数
    public BridgeAbstraction(BridgeImplementor implementor) {
        this.implementor = implementor;
    }

    // 自身的行为和属性
    public void request() {
        this.implementor.doSomething();
    }

    // 获得实现化角色
    public BridgeImplementor getImplementor() {
        return implementor;
    }
}

/**
 * 实现化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:19
 */
public interface BridgeImplementor {

    public void doSomething();
    public void doAnything();
}

/**
 * 修正抽象化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:39
 */
public class BridgeRefinedAbstraction extends BridgeAbstraction {
    public BridgeRefinedAbstraction(BridgeImplementor implementor) {
        super(implementor);
    }

    @Override
    public void request() {
        super.request();
        super.getImplementor().doAnything();
    }
}

/**
 * 具体实现化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:39
 */
public class BridgeConcreteImplementor1 implements BridgeImplementor {
    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + ": doSomething.");
    }

    @Override
    public void doAnything() {
        System.out.println(this.getClass().getName() + ": doAnything.");
    }
}

/**
 * 具体实现化角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 16:39
 */
public class BridgeConcreteImplementor2 implements BridgeImplementor {
    @Override
    public void doSomething() {
        System.out.println(this.getClass().getName() + ": doSomething.");
    }

    @Override
    public void doAnything() {
        System.out.println(this.getClass().getName() + ": doAnything.");
    }
}

```

### Example
```java
/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 11:59
 */
public abstract class BridgeProduct {
    public abstract void beProducted();
    public abstract void beSelled();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:00
 */
public class BridgeHouse extends BridgeProduct {
    @Override
    public void beProducted() {
        System.out.println("生产出的房子是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:02
 */
public class BridgeIpod extends BridgeProduct {
    @Override
    public void beProducted() {
        System.out.println("生产出的IPod是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的IPod卖出去了...");
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:02
 */
public abstract class BridgeCorp {
    private BridgeProduct product;

    public BridgeCorp(BridgeProduct product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.beProducted();
        this.product.beSelled();
    }
}

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

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 11:58
 */
public class BridgeTests {

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
```

## 应用
### 优点
- 抽象与实现分离
它完全是为了解决继承的缺点而提出的设计模式。在这种模式下，可不受抽象的约束，不用再绑定到一个固定的抽象层次上。

- 优秀的扩充能力
- 实现细节对客户透明

### 使用场景
- 不希望或不适用使用继承的场景
- 接口或抽象类不稳定的场景
- 重用性要求较高的场景

### 注意事项
- 在进行系统设计时，发现类的继承有N层时，可以考虑使用桥梁模式。

### 最佳实践

