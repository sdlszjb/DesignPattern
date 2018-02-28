# 适配器模式

## 定义
将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
> 适配器模式又叫做包装模式（wrapper)

```java
/**
 * target接口 目标
 */
public interface WrapperTarget {

    public void request();
}
/**
 * 具体target 目标
 */
public class WrapperConcreteTarget implements WrapperTarget {
    @Override
    public void request() {
        System.out.println("If you need any help, pls call me.");
    }
}

/**
 * 源接口
 */
public interface WrapperAdaptee {
    public void doSomething();
}

/**
 * 具体adaptee 源
 */
public class WrapperConcreteAdaptee implements WrapperAdaptee {
    @Override
    public void doSomething() {
        System.out.println("I'm kind of busy, leave me alone, pls!");
    }
}

/**
 * 适配器
 * 将 adaptee 适配成 target
 */
public class WrapperAdapter implements WrapperTarget {

    private WrapperAdaptee adaptee;

    public WrapperAdapter(WrapperAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.doSomething();
    }
}
```
## 优点
- 可以让没有任何关系的类在一起运行，只要适配器这个角色能够搞定他们就成。
- 增加了类的透明性
我们具体访问的是target目标角色，但是具体的实现委托给了源角色，这对高层次模块是透明的。
- 提高了类的复用度
- 灵活性非常好
## 缺点

## 使用场景
- 有冬季修改一个已经投产中的接口，适配器是最适合的模式。

## 注意事项
- 开发阶段适配器模式不是优先考虑的模式。
- 项目必须遵守依赖倒置原则和里式替换原则，否则不能使用适配器模式。

## 扩展
- 适配器模式还可用于类的聚合。将多各类的功能聚合成一个目标类。

## 最佳实践
他可通过把非本系统接口的对象包装成本系统可以接受的对象，从而简化了系统大规模变更风险的存在