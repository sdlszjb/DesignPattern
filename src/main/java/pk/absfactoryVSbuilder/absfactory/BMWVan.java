package pk.absfactoryVSbuilder.absfactory;

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
