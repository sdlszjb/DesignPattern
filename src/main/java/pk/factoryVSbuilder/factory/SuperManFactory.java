package pk.factoryVSbuilder.factory;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:18
 */
public class SuperManFactory {
    public static SuperMan createSuperMan(String type) {
        switch (type) {
            case "adult":
                return new AdultSuperMan();
            case "child":
                return new ChildSuperMan();
            default:
                return null;
        }
    }
}
