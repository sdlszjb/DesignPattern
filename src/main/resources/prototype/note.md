# 原型模式
> 看到prototype，我就想起了反人类的JavaScript...
## 定义
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
> 原型模式的简单程度仅次于单例模式和迭代器模式，使用场景非常非常多。。。（回头想想自己可以有很多地方用到他的）

```java
/**
 * created by lsk on 2018-02-26 18:02.
 *
 * 原型模式
 * 
 * @author 庄壮壮
 */
public class PrototypeClass implements Cloneable {

    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = null;
        prototypeClass = (PrototypeClass) super.clone();
        return prototypeClass;
    }
}

/**
 * created by lsk on 2018-02-26 18:08.
 * 
 * 测试类
 * 
 * @author 庄壮壮
 */
public class PrototypeTests {

    @Test
    public void testClient() {
        List<PrototypeClass> classes = new ArrayList<>();
        PrototypeClass prototypeClass = new PrototypeClass();
        for (int i=0; i<10; i++) {
            try {
                classes.add(prototypeClass.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(prototypeClass);
        for (PrototypeClass c : classes) {
            System.out.println(c);
        }
    }
}

```

## 优点
- 性能优良
二进制拷贝，比new产生对象性能好，特别是在一个循环体内产生大量对象时。
- 逃避构造函数的约束
这也是他的缺点也是优点，直接在内存中拷贝，构造函数不会执行。

## 使用场景
- 资源优化环境
类初始化消耗资源过多，包括数据资源、硬件资源。
- 系能和安全要求场景
通过new产生一个对象要求非常繁琐的数据准备或者访问权限，可以使用原型模式。
- 一个对象多个修改者的场景
一个对象要提供给其他对象访问，并且各个调用者可能都需要修改其值时，可以考虑使用原型模式。

> 在实际项目中使用，一般配合工厂方法模式出现，通过clone创建对象，然后通过工厂方法提供给调用者。

## 使用注意事项
- 构造函数不会执行
- 深拷贝和浅拷贝
```java


/**
 * created by lsk on 2018-02-26 18:17.
 *
 * 深拷贝
 * 
 * @author 庄壮壮
 */
public class PrototypeDeep implements Cloneable {

    private List<String> list = new ArrayList<>();

    @Override
    @SuppressWarnings("unchecked")
    public PrototypeDeep clone() throws CloneNotSupportedException {
        PrototypeDeep deep = null;

        deep = (PrototypeDeep) super.clone();

        deep.list = (List<String>) ((ArrayList<String>)this.list).clone();

        return deep;
    }

    public void addData(String s) {
        this.list.add(s);
    }

    public void printData() {
        for (String s : list) {
            System.out.println(s);
        }
    }
}

/**
 * created by lsk on 2018-02-26 18:08.
 *
 * @author 庄壮壮
 */
public class PrototypeTests {

    @Test
    public void testDeep() throws CloneNotSupportedException {
        System.out.println("---- prototype ----");
        PrototypeDeep deep = new PrototypeDeep();
        deep.addData("a");
        deep.addData("b");
        deep.addData("c");
        deep.addData("d");
        deep.printData();

        System.out.println("---- Deep ----");
        PrototypeDeep deep2 = deep.clone();
        deep2.printData();
    }
}
```

## clone与final
- 对象的clone与final关键字是有冲突的。
> 要使用clone方法，类的成员变量上就不能由final关键字。

## 最佳实践
- 原型模式可以先产出一个包含大量共有信息的类，然后可以拷贝出副本，修正细节信息，建立完整的个性对象。
- 克隆人哦～！