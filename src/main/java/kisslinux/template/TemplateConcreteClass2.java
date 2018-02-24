package kisslinux.template;

/**
 * created by lsk on 2018-02-24 17:48.
 *
 * 具体模板类 2
 *
 * @author 庄壮壮
 */
public class TemplateConcreteClass2 extends TemplateAbstractClass{
    @Override
    protected void doSomething() {
        System.out.println("Concrete 2 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("Concrete 2 doAnything");
    }
}
