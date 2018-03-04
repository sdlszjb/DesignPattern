package pk.factoryVSbuilder.builder;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:25
 */
public abstract class Builder {
    protected final SuperMan superMan = new SuperMan();

    public void setBody(String body) {
        this.superMan.setBody(body);
    }

    public void setSpecialTalent(String st) {
        this.superMan.setSpecialTalent(st);
    }

    public void setSpecialSymbol(String ss) {
        this.superMan.setSpecialSymbol(ss);
    }

    public abstract SuperMan getSuperMan();
}
