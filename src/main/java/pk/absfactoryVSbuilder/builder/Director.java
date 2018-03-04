package pk.absfactoryVSbuilder.builder;

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
