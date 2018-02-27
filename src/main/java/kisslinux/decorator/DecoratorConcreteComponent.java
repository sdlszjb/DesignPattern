package kisslinux.decorator;

/**
 * created by lsk on 2018-02-27 17:21.
 *
 * 具体构件类举例
 *
 * @author 庄壮壮
 */
public class DecoratorConcreteComponent extends DecoratorComponent {
    @Override
    public String operate() {
        return TAG;
    }
}
