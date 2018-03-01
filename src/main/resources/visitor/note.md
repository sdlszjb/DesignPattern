# 访问者模式

## 定义
封装一些作用于某种数据结构中的各元素的操作，他可以在不改变数据结构的前提下定义作用于这些元素的新的操作。

```java
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

/**
 * 具体元素 2
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:07
 */
public class VisitorConcreteElement2 extends VisitorElement {

    public VisitorConcreteElement2(String name, int age) {
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

/**
 * 模拟 数据获取
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:15
 */
public class VisitorObjectStructure {
    public static VisitorElement createElement() {
        Random random = new Random();
        int age = random.nextInt(100);
        if (age > 50) {
            return new VisitorConcreteElement1("big", age);
        } else {
            return new VisitorConcreteElement2("small", age);
        }
    }
}

/**
 * 测试类
 * 
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 21:20
 */
public class VisitorTests {

    @Test
    public void testClient() {
        for (int i = 0; i < 10; i++) {
            VisitorElement element = VisitorObjectStructure.createElement();
            element.accept(new VisitorConcreteVisitor());
        }
    }
}
```
> 通过访问者模式，对具体元素更容易访问，不管他是什么对象，只要他在一个容器中，都可以通过访问者来访问。

## 应用
### 优点
- 符合单一职责原则
Element和Visitor各负其责

- 优秀的扩展性
只需要扩展Visitor就可以

- 灵活性高
访问者可分别针对不同的Element进行扩展操作，例如员工*2，经理*4，总经理*8...

### 缺点
- 具体元素对访问者公布细节
访问者必须关注其他类的内部细节，这是迪米特法则不建议的。

- 具体元素变更困难
- 违背了依赖倒置的原则
访问者依赖的是具体元素，而不是抽象元素，这破坏了依赖倒置原则，扩展困难。

### 使用场景
- 一个对象结构包含很多类对象，他们有不同的接口，而你想对这些对象实施一些依赖于其具体类的操作，也就是 迭代器 已经不能胜任的场景
- 需要对一个对象结构中的对象进行很多不同并且不相关的操作，而你想避免让这些操作污染这些对象的类。

> 在这些情况一定要使用访问者模式：业务规则需要遍历多个不同的对象。
> 访问者是对迭代器的补充
> 充当拦截器角色

### 扩展
#### 统计功能
在visit方法中搞点事情
#### 多个访问者
Element可以同时供多个访问者访问。
ele.visit(visitorA);
ele.visit(visitorB);

#### 双分派
- Java是一个支持双分派的单分派语言

### 最佳实践
- 是一种接种规则模式，适合大规模重构的项目，在这一阶段需求已经清晰，原系统的功能点已经明确，通过访问者模式实现功能集中化，如一个统一的报表运算，UI展示等，还可以与其他模式混编建立一套过滤器和拦截器。


