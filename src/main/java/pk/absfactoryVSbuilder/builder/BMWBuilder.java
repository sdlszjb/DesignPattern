package pk.absfactoryVSbuilder.builder;

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
