package kisslinux.decorator;

/**
 * created by lsk on 2018-02-27 17:19.
 *
 * 抽象构件
 *
 * @author 庄壮壮
 */
public abstract class DecoratorComponent {
    protected final String TAG = this.getClass().getSimpleName();
    public abstract String operate();
}
