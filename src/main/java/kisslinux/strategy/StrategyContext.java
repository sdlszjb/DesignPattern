package kisslinux.strategy;

/**
 * created by lsk on 2018-02-27 23:43.
 *
 * 封装角色
 *
 * @author 庄壮壮
 */
public class StrategyContext {

    // 抽象策略
    private StrategyStrategy strategy = null;

    // 构造函数设置具体策略
    public StrategyContext(StrategyStrategy strategy) {
        this.strategy = strategy;
    }

    // 封装后的策略方法
    public void doAnything() {
        this.strategy.doSomething();
    }
}
