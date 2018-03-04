package pk.factoryVSbuilder.builder;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:27
 */
public class AdultSuperManBuilder extends Builder {
    @Override
    public SuperMan getSuperMan() {
        super.setBody("强壮的身体");
        super.setSpecialTalent("会飞行");
        super.setSpecialSymbol("大S");
        return super.superMan;
    }
}
