package kisslinux.visitor;

/**
 * 抽象元素
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:00
 */
public abstract class VisitorElement {
    protected String name = "";
    protected int age;

    public VisitorElement(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 定义业务逻辑
    public abstract void doSomething();

    // 允许谁来访问
    public abstract void accept(VisitorVisitor visitor);
}
