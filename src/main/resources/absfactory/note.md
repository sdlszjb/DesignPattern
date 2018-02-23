# 抽象工厂模式

## 定义
为创建一组相关或相互依赖的对象提供一个接口，并且无需指定他们的具体类。
在多产品族的时候是最适合的。

## 案例

人类有两个族类：男、女。

男 族类 可以有 黑，白，黄三个子等级，扩展混血人很容易；
女 族类 可以有 黑，白，黄三个子等级，扩展混血人很容易；

此时，采用抽象工厂模式最合适。

```java
/**
 * 抽象产品类 A
 */
public abstract class AbsFactoryProductA {

    public void shareMethod() {
        System.out.println(this.getClass().getSimpleName() + ": A shareMethod.");
    }

    public abstract void doSomething();
}
/**
  * 产品A1
  */
 public class AbsFactoryConcreteProductA1 extends AbsFactoryProductA {
     @Override
     public void doSomething() {
         System.out.println("A1 doSomething.");
     }
 }

/**
 * 产品A2
 */
public class AbsFactoryConcreteProductA2 extends AbsFactoryProductA {
    @Override
    public void doSomething() {
        System.out.println("A2 doSomething.");
    }
}

/**
 * 抽象产品类 B
 */
public abstract class AbsFactoryProductB {

    public void shareMethod() {
        System.out.println(this.getClass().getSimpleName() + ": B shareMethod.");
    }

    public abstract void doSomething();
}

/**
 * 产品B1
 */
public class AbsFactoryConcreteProductB1 extends AbsFactoryProductB {
    @Override
    public void doSomething() {
        System.out.println("B1 doSomething.");
    }
}

/**
 * 产品B2
 */
public class AbsFactoryConcreteProductB2 extends AbsFactoryProductB {
    @Override
    public void doSomething() {
        System.out.println("B2 doSomething.");
    }
}

/**
 * 抽象工厂类
 */
public abstract class AbsFactoryCreator {
    // 创建A产品家族
    public abstract AbsFactoryProductA createProductA();
    // 创建B产品家族
    public abstract AbsFactoryProductB createProductB();
}

/**
 * 产品等级 1 的工厂实现类
 */
public class AbsFactoryCreator1 extends AbsFactoryCreator {
    // 生产等级为1的A产品
    @Override
    public AbsFactoryProductA createProductA() {
        return new AbsFactoryConcreteProductA1();
    }

    // 生产等级为1的B产品
    @Override
    public AbsFactoryProductB createProductB() {
        return new AbsFactoryConcreteProductB1();
    }
}

/**
 * 产品等级为 2 的工厂实现类
 */
public class AbsFactoryCreator2 extends AbsFactoryCreator {
    // 生产等级为2的A产品
    @Override
    public AbsFactoryProductA createProductA() {
        return new AbsFactoryConcreteProductA2();
    }

    // 生产等级为12的B产品
    @Override
    public AbsFactoryProductB createProductB() {
        return new AbsFactoryConcreteProductB2();
    }
}
/**
 * 测试类
 */
public class AbsFactoryTests {

    @Test
    public void testClient() {
        AbsFactoryCreator creator1 = new AbsFactoryCreator1();
        AbsFactoryCreator creator2 = new AbsFactoryCreator2();

        AbsFactoryProductA productA1 = creator1.createProductA();
        AbsFactoryProductB productB1 = creator1.createProductB();
        AbsFactoryProductA productA2 = creator2.createProductA();
        AbsFactoryProductB productB2 = creator2.createProductB();

        productA1.doSomething();
        productA2.doSomething();
        productB1.doSomething();
        productB2.doSomething();
    }
}
```

## 优点
1. 封装性
2. 产品族内的约束为非公开状态。例如，工厂可以自由控制A族和B族生产的比例关系。

## 缺点
1. 产品族扩展困难

## 使用场景
1. 一个对象族（或是一组没有任何关系的对象）都有相同的约束，就可以使用抽象工厂模式。

## 注意事项
1. 只是产品族扩展困难，但产品等级扩展非常容易。即，横向扩展容易，纵向扩展困难。

## 最佳实践
例如，一个应用，需要在三个不同平台使用（Win、Android、Linux）上运行，软件功能、应用逻辑、UI是类似的，将软件功能、应用逻辑、UI作为产品族，将不同应用平台作为产品等级。拓展应用平台就可非常容易。