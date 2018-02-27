package cn.kisslinux.soft;

import kisslinux.strategy.StrategyConcreteStrategy1;
import kisslinux.strategy.StrategyConcreteStrategy2;
import kisslinux.strategy.StrategyContext;
import org.junit.Test;

/**
 * created by lsk on 2018-02-27 23:51.
 *
 *  策略模式测试类
 *
 * @author 庄壮壮
 */
public class StrategyTests {

    @Test
    public void testClient() {
        StrategyContext context1= new StrategyContext(new StrategyConcreteStrategy1());
        context1.doAnything();

        StrategyContext context2 = new StrategyContext(new StrategyConcreteStrategy2());
        context2.doAnything();
    }
}
