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
/**
 * created by lsk on 2018-02-24 23:46.
 *
 * @author 庄壮壮
 */
public interface HardProxySubject {
    public void request();
    public HardProxySubject getProxy();
}

/**
 * created by lsk on 2018-02-24 23:47.
 *
 * @author 庄壮壮
 */
public class HardProxyRealSubject implements HardProxySubject {

    private HardProxySubject proxy = null;

    public HardProxyRealSubject() {
    }

    @Override
    public void request() {
        if (this.isProxy()) {
            System.out.println("Request from HardProxyReadSubject.");
        } else {
            System.out.println("Please use proxy to handle this request.");
        }
    }

    /**
     * 找到自己的代理
     * @return HardProxySubject
     */
    @Override
    public HardProxySubject getProxy() {
        this.proxy = new HardProxySubjectProxy(this);
        return this.proxy;
    }

    /**
     * 检测代理是否可用
     * 这里的检测方法是很简单的一种
     * 真实案例会校验Proxy的匹配性
     * @return true/false
     */
    private boolean isProxy() {
        return this.proxy != null;
    }
}

/**
 * created by lsk on 2018-02-24 23:48.
 *
 * @author 庄壮壮
 */
public class HardProxySubjectProxy implements HardProxySubject {

    HardProxySubject subject = null;

    public HardProxySubjectProxy(HardProxySubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    @Override
    public HardProxySubject getProxy() {
        return this;
    }

    private void before() {
        System.out.println("Something before request.");
    }

    private void after() {
        System.out.println("Something after request.");
    }
}

/**
 * created by lsk on 2018-02-24 22:44.
 *
 * @author 庄壮壮
 */
public class ProxyTests {

    @Test
    public void testHardClient() {

        HardProxySubject subject = new HardProxyRealSubject();

        System.out.println("-------\n" +
                "ReadSubject: \n" +
                "-------");
        subject.request();

        System.out.println();
        System.out.println();

        HardProxySubject proxy = new HardProxySubjectProxy(new HardProxyRealSubject());
        System.out.println("-------\n" +
                "MyProxy: \n" +
                "-------");
        proxy.request();


        System.out.println();
        System.out.println();

        System.out.println("-------\n" +
                "RealProxy: \n" +
                "-------");
        HardProxySubject realSub = new HardProxyRealSubject();
        HardProxySubject realProxy = realSub.getProxy();
        realProxy.request();
    }
}
```

### 个性化代理
- 为Proxy设定一个接口，代理类实现多个接口，完成不同人物的整合，代码如下。
- 通常过滤器和拦截器就是这种方式。
```java

/**
 * Proxy接口
 * 定制Proxy自己特性
 */
public interface ProxyProxy {

    /**
     * Proxy自身方法
     */
    public void proxyThing();
}

public class ProxyProxyProxy implements ProxyProxy, ProxySubject {

    private ProxySubject subject = null;

    public ProxyProxyProxy(ProxySubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.proxyThing();
        this.subject.request();
    }

    @Override
    public void proxyThing() {
        System.out.println("The subject class is: " + subject);
    }
}

/**
 * created by lsk on 2018-02-24 22:44.
 *
 * @author 庄壮壮
 */
public class ProxyTests {

    /**
     * 测试 Proxy接口，定制Proxy特性。
     */
    @Test
    public void testProxyInterface() {
        ProxySubject subject = new ProxyProxyProxy(new ProxyRealSubject());
        subject.request();
    }
}
```
### 动态代理
- 这里只是简单制作一个动态代理的Demo，我个人建议，动态代理你要拿出一点时间专门地、系统的学习一下。
> 我时小白，我打算写完设计模式之后实现一个AOP框架来对此进行巩固和掌握。
- 动态代理在运行阶段才制定代理对象。流行的面向横切面编程，就是（AOP），核心技术就是动态代理机制。
```java
/**
 * 一个普通的业务类型接口
 */
public interface DynamicProxySubject {

    public String doSomething();
}
/**
 * 一个普通的业务类型接口的实现
 */
public class DynamicProxyRealSubject implements DynamicProxySubject {
    @Override
    public String doSomething() {
        System.out.println("Running from real subject.");
        return "I'm real subject.";
    }
}

/**
 * 动态代理通知接口
 * 想要附加在业务类上的功能。
 * 
 */
public interface DynamicProxyAdvice {
    public void exec();
}

/**
 * 前置通知
 */
public class DynamicProxyBeforeAdvice implements DynamicProxyAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知。");
    }
}

/**
 * 后置通知
 */
public class DynamicProxyAfterAdvice implements DynamicProxyAdvice {
    @Override
    public void exec() {
        System.out.println("我是后置通知！");
    }
}

/**
 * 实现InvocationHandler
 */
public class DynamicProxyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target = null;

    public DynamicProxyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     * @param proxy proxy
     * @param method method
     * @param args args
     * @return Result
     * @throws Throwable Exception
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (true) {
            (new DynamicProxyBeforeAdvice()).exec();
        }
        Object object =  method.invoke(this.target, args);
        
        if (true) {
            (new DynamicProxyAfterAdvice()).exec();
        }
        return object;
    }
}

/**
 * 通用 目标对象代理对象获取工具
 * @param <T>
 */
public class DynamicProxyProxy<T> {

    /**
     * 获取目标对象的代理对象
     * @param loader ClassLoader
     * @param interfaces interfaces
     * @param handler InvocationHandler
     * @param <T> T
     * @return proxy
     */
    @SuppressWarnings("unchecked")
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }
}

/**
 * created by lsk on 2018-02-26 17:22.
 *
 * 针对DynamicProxySubject的封装
 * 让上层调用更简单。
 *
 * @author 庄壮壮
 */
public class DynamicProxySubjectProxy extends DynamicProxyProxy<DynamicProxySubject> {
    public static <T> T newProxyInstance (DynamicProxySubject subject) {
        ClassLoader loader = subject.getClass().getClassLoader();
        Class<?>[] classes = subject.getClass().getInterfaces();
        InvocationHandler handler = new DynamicProxyInvocationHandler(subject);

        return newProxyInstance(loader, classes, handler);
    }
}

/**
 * created by lsk on 2018-02-24 22:44.
 * 测试类
 * @author 庄壮壮
 */
public class ProxyTests {

    @Test
    public void testDynamicProxy() {
        DynamicProxySubject subject = new DynamicProxyRealSubject();
        DynamicProxySubject proxy = DynamicProxySubjectProxy.newProxyInstance(subject);
        proxy.doSomething();
    }
}

```
> 要实现动态代理的首要条件时，被代理类必须实现一个接口。与JDK的动态代理类似的还有CGLIB，可以实现不需要接口即可实现动态代理。
> JDK的实现方式是在本地动态生成Class文件，然后加载到内存执行。具体可以查看JDK的源码。

##  最佳实践
- 系统框架、事务处理各种。。。应用广泛。