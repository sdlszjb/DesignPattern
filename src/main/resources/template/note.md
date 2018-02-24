# 模板方法模式

## 定义
定义一个操作中的算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的特定步骤。

```java
/**
 * created by lsk on 2018-02-24 17:47.
 *
 * 抽象模板类
 *
 * @author 庄壮壮
 */
public abstract class TemplateAbstractClass {
    // 基本方法
    protected abstract void doSomething();

    // 基本方法
    protected abstract void doAnything();

    /**
     * 模板方法，一般为final
     */
    public final void templateMethod() {
        this.doSomething();
        this.doAnything();
    }
}

/**
 * created by lsk on 2018-02-24 17:48.
 *
 * 具体模板类 1
 *
 * @author 庄壮壮
 */
public class TemplateConcreteClass1 extends TemplateAbstractClass{
    @Override
    protected void doSomething() {
        System.out.println("Concrete 1 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("Concrete 1 doAnything");
    }
}

/**
 * created by lsk on 2018-02-24 17:48.
 *
 * 具体模板类 2
 *
 * @author 庄壮壮
 */
public class TemplateConcreteClass2 extends TemplateAbstractClass{
    @Override
    protected void doSomething() {
        System.out.println("Concrete 2 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("Concrete 2 doAnything");
    }
}

/**
 * created by lsk on 2018-02-24 17:50.
 *
 * @author 庄壮壮
 */
public class TemplateTests {

    @Test
    public void testClient() {
        TemplateAbstractClass c1 = new TemplateConcreteClass1();
        TemplateAbstractClass c2 = new TemplateConcreteClass2();

        c1.templateMethod();
        c2.templateMethod();
    }
}
```
> 一般情况下，抽象模板中的基本方法尽量设计为protected类型；实现类若非必要，尽量不要扩大父类中的访问权限。

## 优点
- 封装不变部分，扩展可变部分
- 提取公共部分代码，便于维护
- 行为由父类控制，子类实现

## 缺点
- 子类执行结果影响父类结果，在复杂系统中，会带来代码阅读的难度。

## 使用场景
- 多个子类由共有的方法，并且逻辑相同
- 重要、复杂的算法，把核心算法设计为模板方法，周边功能由子类实现。
- 重构时，把相同的代码放到父类中，然后，通过钩子函数，约束其行为。

## 扩展
- 模板方法按照一定的顺序调用基本方法。为其设置钩子方法（HookMethod)可决定公共部分的执行结果。

## 最佳实践
当你想在父类中调用子类方法的时候。。。