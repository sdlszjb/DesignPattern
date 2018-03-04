package pk.absfactoryVSbuilder.absfactory;

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
