# 抽象工厂模式 VS 建造者模式

- 抽象工厂实现对产品家族的创建，一个产品家族是一类维度不同的产品组合，不需要关心构建过程，只关心什么产品由什么工厂生产
- 建造者则要求按照指定的蓝图建造产品，目的是组装零件而产生产品。

### 抽象工厂模式
```java
/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:48
 */
public interface Car {
    public String getBand();
    public String getModel();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:49
 */
public abstract class AbsBMW implements Car {

    private final static String BMW_BAND = "宝马汽车";
    @Override
    public String getBand() {
        return BMW_BAND;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:49
 */
public abstract class AbsBenz implements Car {
    private final static String BENZ_BAND = "奔驰汽车";

    @Override
    public String getBand() {
        return BENZ_BAND;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:50
 */
public class BMWSuv extends AbsBenz {
    private final static String X_SEARIES = "X系列车型SUV";

    @Override
    public String getModel() {
        return X_SEARIES;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:50
 */
public class BMWVan extends AbsBenz {

    private final static String SEVENT_SEARIES = "7系列车型商务车";

    @Override
    public String getModel() {
        return SEVENT_SEARIES;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:50
 */
public class BenzSuv extends AbsBenz {
    private final static String G_SEARIES = "G系列SUV";

    @Override
    public String getModel() {
        return G_SEARIES;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:50
 */
public class BenzVan extends AbsBenz {
    private final static String R_SEARIES = "R系列商务车";

    @Override
    public String getModel() {
        return R_SEARIES;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:54
 */
public interface CarFactory {

    public Car createSUV();
    public Car createVAN();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:54
 */
public class BMWFactory implements CarFactory {
    @Override
    public Car createSUV() {
        return new BMWSuv();
    }

    @Override
    public Car createVAN() {
        return new BMWVan();
    }
}
```
### 建造者
```java
/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:19
 */
public interface ICar {
    public String getWheel();
    public String getEngine();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:20
 */
public class Car implements ICar {

    private String engine;
    private String wheel;

    public Car(String engine, String wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }

    @Override
    public String getWheel() {
        return wheel;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "车的轮子是：" + wheel + "\n" +
                "车的引擎是：" + engine;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:22
 */
public abstract class CarBuilder {

    private ICar car;
    private Blueprint bp;

    public Car buildCar() {
        return new Car(buildEngine(), buildWheel());
    }

    public void receiveBlueprint(Blueprint bp) {
        this.bp = bp;
    }

    protected Blueprint getBlueprint() {
        return bp;
    }

    protected abstract String buildWheel();
    protected abstract String buildEngine();

}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:22
 */
public class Blueprint {
    private String wheel;
    private String engine;

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}


/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:25
 */
public class BMWBuilder extends CarBuilder {
    @Override
    protected String buildWheel() {
        return super.getBlueprint().getWheel();
    }

    @Override
    protected String buildEngine() {
        return super.getBlueprint().getEngine();
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:25
 */
public class BenzBuilder extends CarBuilder {
    @Override
    protected String buildWheel() {
        return super.getBlueprint().getWheel();
    }

    @Override
    protected String buildEngine() {
        return super.getBlueprint().getEngine();
    }
}


/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:25
 */
public class Director {

    private CarBuilder benzBuilder = new BenzBuilder();
    private CarBuilder bmwBuilder = new BMWBuilder();

    public ICar createBenzSUV() {
        return createCar(benzBuilder, "benz引擎", "benz轮胎");
    }

    public ICar createBMWVan() {
        return createCar(bmwBuilder, "bmw引擎", "bmw轮胎");
    }

    public ICar createComplexCar() {
        return createCar(bmwBuilder, "benz引擎", "bmw轮胎");
    }

    private ICar createCar(CarBuilder carBuilder, String engine, String wheel) {
        Blueprint bp = new Blueprint();
        bp.setEngine(engine);
        bp.setWheel(wheel);

        System.out.println("获得生产蓝图！");
        carBuilder.receiveBlueprint(bp);
        return carBuilder.buildCar();
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 17:30
 */
public class Client {

    @Test
    public void testClient() {
        Director director =new Director();
        System.out.println("===制造一辆奔驰SUV===");
        ICar benzSuv = director.createBenzSUV();
        System.out.println(benzSuv);

        System.out.println("\n===制造一辆宝马商务车===");
        ICar bmwVan = director.createBMWVan();
        System.out.println(bmwVan);

        System.out.println("\n===制造一辆混合车===");
        ICar complexCar = director.createComplexCar();
        System.out.println(complexCar);
    }
}

```

### 最佳实践
- 抽象工厂是从更高层次去看对象的构建，具体的实现隐藏在工厂内部。
- 给定蓝图，导演按照蓝图去组建具体的车辆。