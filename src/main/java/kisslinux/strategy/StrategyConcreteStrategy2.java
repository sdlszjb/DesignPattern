package kisslinux.strategy;

/**
 * created by lsk on 2018-02-27 23:44.
 *
 * 具体策略角色
 *
 * @author 庄壮壮
 */
public class StrategyConcreteStrategy2 implements StrategyStrategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略角色2的运算法则");
    }
}
