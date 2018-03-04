package pk.absfactoryVSbuilder.absfactory;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 14:55
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createSUV() {
        return new BenzSuv();
    }

    @Override
    public Car createVAN() {
        return new BenzVan();
    }
}
