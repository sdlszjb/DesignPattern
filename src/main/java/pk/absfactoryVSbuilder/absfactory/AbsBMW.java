package pk.absfactoryVSbuilder.absfactory;

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
