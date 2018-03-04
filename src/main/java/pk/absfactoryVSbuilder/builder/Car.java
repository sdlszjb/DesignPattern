package pk.absfactoryVSbuilder.builder;

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
