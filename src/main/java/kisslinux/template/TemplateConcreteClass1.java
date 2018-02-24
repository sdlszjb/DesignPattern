package kisslinux.template;

/**
 * created by lsk on 2018-02-24 17:48.
 *
 * 具体模板类 1
 *
 * @author 庄壮壮
 */
public class TemplateConcreteClass1 extends TemplateAbstractClass{
    @Override
    protected void doSomething() {
        System.out.println("Concrete 1 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("Concrete 1 doAnything");
    }
}
