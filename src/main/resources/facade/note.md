# 门面模式

## 定义
也叫做外观模式。要求一个子系统的外部与内部的通信必须通过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。

```java
/**
 * 子系统 A
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassA {
    public void doSomethingA() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}

/**
 * 子系统 B
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassB {
    public void doSomethingB() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}

/**
 * 子系统 C
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:31
 */
public class FacadeClassC {
    public void doSomethingC() {
        System.out.println(this.getClass().getName() + ": " + this);
    }
}

/**
 * 门面对象
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:25
 */
public class FacadeFacade {

    // 被委托对象
    private FacadeClassA a = new FacadeClassA();
    private FacadeClassB b = new FacadeClassB();
    private FacadeClassC c = new FacadeClassC();

    // 提供给外部访问的方法
    public void methodA() {
        this.a.doSomethingA();
    }

    public void methodB() {
        this.b.doSomethingB();
    }

    public void methodC() {
        this.c.doSomethingC();
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 13:36
 */
public class FacadeTests {

    @Test
    public void testClient() {
        FacadeFacade facade = new FacadeFacade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
```

## 优点
- 减少系统的相互依赖
- 提高了灵活性
- 提高安全性

## 缺点
- 不符合开闭原则，使用时只能修改门面角色的代码，风险大。

## 使用场景
- 为一个复杂的模块或子系统提供一个供外界访问的接口。
- 子系统相对独立，外界对子系统的访问只要黑箱操作。
- 预防低水平人员带来的风险扩展

## 注意事项
- 避免门面过大，拆分为多个门面
- 可提供不同访问路径，提供多个门面
- 门面不参与子系统内的业务逻辑
例如上面的案例methodC()方法应该避免出现下面的行为。这不仅违反了单一职责原则，也破坏了系统的封装性。
那遇到这样的情况应该怎么处理？建立一个封装类，封装完毕后再提供给门面对象。
```java
 public class Facade {
     public void methodC() {
         this.a.doSomethingA();
         this.b.doSomethingB();
     }
 }
```
> 门面模式中，门面角色应该是稳定、不经常变化的，一旦进入生产环节就不应该修改的，是系统对外的接口，不管业务逻辑怎么变化，门面要保持同一个门面，同样的方法。

## 最佳实践
- 算法或者业务比较复杂，就可以封装出一个或多个门面出来，项目结构简单，扩展性好。
- 对于大型项目，为了避免人员带来的风险，也可以使用门面模式。
