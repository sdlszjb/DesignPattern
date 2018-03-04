package pk.absfactoryVSbuilder.absfactory;

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
