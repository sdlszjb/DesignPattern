package kisslinux.decorator;

/**
 * created by lsk on 2018-02-27 17:20.
 *
 * 抽象装饰类
 *
 * @author 庄壮壮
 */
public abstract class DecoratorDecorator extends DecoratorComponent {

    private DecoratorComponent component = null;

    public DecoratorDecorator(DecoratorComponent component) {
        this.component = component;
    }

    // 这里可不重写该方法
    @Override
    public String operate() {
        return this.component.operate();
    }
}
