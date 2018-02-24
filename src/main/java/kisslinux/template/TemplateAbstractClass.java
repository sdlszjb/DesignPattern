package kisslinux.template;

/**
 * created by lsk on 2018-02-24 17:47.
 *
 * 抽象模板类
 *
 * @author 庄壮壮
 */
public abstract class TemplateAbstractClass {
    // 基本方法
    protected abstract void doSomething();

    // 基本方法
    protected abstract void doAnything();

    /**
     * 模板方法，一般为final
     */
    public final void templateMethod() {
        this.doSomething();
        this.doAnything();
    }
}
