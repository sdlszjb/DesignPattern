package pk.factoryVSbuilder.builder;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:27
 */
public class ChildSuperManBuilder extends Builder {
    @Override
    public SuperMan getSuperMan() {
        super.setBody("灵活的身体");
        super.setSpecialTalent("刀枪不入");
        super.setSpecialSymbol("小S");
        return super.superMan;
    }
}
