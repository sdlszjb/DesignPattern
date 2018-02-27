package kisslinux.decorator;

/**
 * created by lsk on 2018-02-27 17:23.
 *
 * 具体装饰类 2 给原字符串附加东西
 *
 * @author 庄壮壮
 */
public class DecoratorConcreteDecorator2 extends DecoratorDecorator {
    public DecoratorConcreteDecorator2(DecoratorComponent component) {
        super(component);
    }

    @Override
    public String operate() {
       String result = super.operate();
       result = TAG +"{" + result + "}";
       return result;
    }
}
