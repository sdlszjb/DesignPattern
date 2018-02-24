# 代理模式

## 定义
为其他对象提供一种代理以控制对这个对象的访问。

### 静态代理
```java
/**
 * created by lsk on 2018-02-24 22:36.
 *
 * 一个普通的业务类型接口
 *
 * 抽象类或者接口
 *
 * 无其他要求
 *
 * @author 庄壮壮
 */
public interface ProxySubject {

    public void request();
}

/**
 * created by lsk on 2018-02-24 22:37.
 *
 * 真实主题类
 *
 * 正常的业务逻辑处理
 *
 * @author 庄壮壮
 */
public class ProxyRealSubject implements ProxySubject {
    @Override
    public void request() {
        System.out.println("this is real subject request.");
    }
}

/**
 * created by lsk on 2018-02-24 22:38.
 *
 * @author 庄壮壮
 */
public class ProxySubjectProxy implements ProxySubject {

    // 要代理的实现类
    private ProxySubject subject = null;

    // 默认被代理者
    public ProxySubjectProxy() {
        this .subject = new ProxySubjectProxy();
    }

    // 通过构造函数传递代理者
    public ProxySubjectProxy(ProxySubject _subject) {
        this.subject = _subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    // 预处理
    private void before() {
        System.out.println("Something before request from proxy.");
    }

    // 后处理
    private void after() {
        System.out.println("Something after request from proxy.");
    }
}

/**
 * created by lsk on 2018-02-24 22:44.
 *
 * @author 庄壮壮
 */
public class ProxyTests {

    @Test
    public void testClient() {
        ProxySubject subject = new ProxySubjectProxy(new ProxyRealSubject());
        subject.request();
    }
}

```

## 优点
- 职责清晰。真实角色实现实际业务逻辑，后期为其增加非本职职责的事务。
- 高扩展性。代理类可以不做任何修改支持具体主题角色的业务逻辑变更（接口不变的前提）。
- 智能化。

## 使用场景
- 最典型的Spring AOP。

## 扩展
### 普通代理
用户要知道Proxy代理类的存在。
> 普通代理模式的约束问题，尽量通过编程规范约束，而不是使用技术约束的方式进行。
### 强制代理
调用者直接调用真实角色，而不用关心代理是否存在，代理的产生由真实角色决定。
```java

```
### 动态代理

