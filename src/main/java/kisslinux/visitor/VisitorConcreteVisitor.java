package kisslinux.visitor;

/**
 * 具体访问者 A
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:11
 */
public class VisitorConcreteVisitor implements VisitorVisitor {
    @Override
    public void visit(VisitorConcreteElement1 element) {
        System.out.println(this.getClass().getName() + " Visit: " + element.getClass().getName());
        element.doSomething();
    }

    @Override
    public void visit(VisitorConcreteElement2 element) {
        System.out.println(this.getClass().getName() + " Visit: " + element.getClass().getName());
        element.doSomething();
    }
}
