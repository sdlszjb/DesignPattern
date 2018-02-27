# 装饰者模式

## 定义

```java
/**
 * created by lsk on 2018-02-27 17:19.
 *
 * 抽象构件
 *
 * @author 庄壮壮
 */
public abstract class DecoratorComponent {
    protected final String TAG = this.getClass().getSimpleName();
    public abstract String operate();
}

/**
 * created by lsk on 2018-02-27 17:21.
 *
 * 具体构件类举例
 *
 * @author 庄壮壮
 */
public class DecoratorConcreteComponent extends DecoratorComponent {
    @Override
    public String operate() {
        return TAG;
    }
}


/**
 * created by lsk on 2018-02-27 17:20.
 *
 * 抽象装饰类
 *
 * @author 庄壮壮
 */
public abstract class DecoratorDecorator extends DecoratorComponent {

    private DecoratorComponent component = null;

    public DecoratorDecorator(DecoratorComponent component) {
        this.component = component;
    }

    // 这里可不重写该方法
    @Override
    public String operate() {
        return this.component.operate();
    }
}

/**
 * created by lsk on 2018-02-27 17:23.
 *
 * 具体装饰类 1 给原字符串附加东西
 *
 * @author 庄壮壮
 */
public class DecoratorConcreteDecorator1 extends DecoratorDecorator {
    public DecoratorConcreteDecorator1(DecoratorComponent component) {
        super(component);
    }

    @Override
    public String operate() {
       String result = super.operate();
       result = TAG +"[" + result + "]";
       return result;
    }
}

/**
 * created by lsk on 2018-02-27 17:23.
 *
 * 具体装饰类 2 给原字符串附加东西
 * 
 * @author 庄壮壮
 */
public class DecoratorConcreteDecorator2 extends DecoratorDecorator {
    public DecoratorConcreteDecorator2(DecoratorComponent component) {
        super(component);
    }

    @Override
    public String operate() {
       String result = super.operate();
       result = TAG +"{" + result + "}";
       return result;
    }
}
```

## 优点
- 装饰类和被装饰类可以独立发展，而不会相互耦合。
- 装饰模式时继承关系的一种替代方案。
- 装饰模式可以动态地扩展一个实现类的功能。

## 缺点
- 多层装饰会增加复杂性（你看开Java的IO就晓得了）

## 使用场景
- 需要扩展一个类的功能，或给一个类增加附加功能。
- 需要动态地给一个对象增加功能，这些功能可以动态地撤销。
- 需要为一批的兄弟进行改装或者增加功能，首选装饰模式。

## 最佳实践
- 继承的补充
- 扩展性好