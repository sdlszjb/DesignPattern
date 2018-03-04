package pk.factoryVSbuilder.builder;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:29
 */
public class Director {
    private static Builder adultBuilder = new AdultSuperManBuilder();
    private static Builder childBuilder = new ChildSuperManBuilder();

    public static SuperMan getAdultSuperMan() {
        return adultBuilder.getSuperMan();
    }

    public static SuperMan getChildSuperMan() {
        return childBuilder.getSuperMan();
    }
}
