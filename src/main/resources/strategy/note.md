# 策略模式

## 定义
定义一组算法，将每个算法都封装起来，并且使他们之间可以互换。

```java
/**
 * created by lsk on 2018-02-27 23:43.
 *
 * 抽象策略角色
 *
 * @author 庄壮壮
 */
public interface StrategyStrategy {
    public void doSomething();
}

/**
 * created by lsk on 2018-02-27 23:44.
 *
 * 具体策略角色
 *
 * @author 庄壮壮
 */
public class StrategyConcreteStrategy1 implements StrategyStrategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略角色1的运算法则");
    }
}

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
```

## 优点
- 算法可以自由切换
- 避免使用多重条件判断
由其他模块决定采用何种策略。
- 扩展性良好

## 缺点
- 策略类数量增多
- 所有的策略类都要对外暴露

## 使用场景
- 多个类只有在算法或行为上稍有不同的场景
- 算法需要自由切换的场景
- 需要屏蔽算法规则的场景

## 注意事项
- 策略类数量超过4个，就要考虑使用混合模式。
- 重点在于，如何解决策略类膨胀和对外暴露问题

## 扩展
- 策略枚举。

## 最佳实践
- 策略模式和枚举类型结合，是最佳解决办法。
- 一般通过工厂方法模式来实现策略类的声明