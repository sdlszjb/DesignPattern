package kisslinux.visitor;

/**
 * 具体元素 1
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:07
 */
public class VisitorConcreteElement1 extends VisitorElement {

    public VisitorConcreteElement1(String name, int age) {
        super(name, age);
    }

    @Override
    public void doSomething() {
        System.out.println(this.name + " do something, age is " + this.age);
    }

    @Override
    public void accept(VisitorVisitor visitor) {
        visitor.visit(this);
    }
}
