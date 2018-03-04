package pk.absfactoryVSbuilder.absfactory;

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
