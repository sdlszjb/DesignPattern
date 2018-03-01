package kisslinux.visitor;

/**
 * 抽象访问者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:05
 */
public interface VisitorVisitor {
    public void visit(VisitorConcreteElement1 element);
    public void visit(VisitorConcreteElement2 element);
}
