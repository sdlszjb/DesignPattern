package pk.absfactoryVSbuilder.builder;

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
