# 单例模式
## 定义
确保某一个类只有一个实例，并且自行实例化向整个操作系统提供这个实例。

### 通用代码
```java
/**
 * 线程安全
 * 饿汉式单例模式
 */
public class ThreadSafeSingleton {
    private static final ThreadSafeSingleton threadSafeSingleton = new ThreadSafeSingleton();

    // 限制实例化
    private ThreadSafeSingleton() {
    }

    // 获取实例对象
    public static ThreadSafeSingleton getSingleton() {
        return threadSafeSingleton;
    }
}
```
### 测试类
```java

public class SingletonTests {

    @Test
    public void testThreadSafeSingleton() throws InterruptedException {
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        new Thread(new ThreadSafeRunnable()).start();
        
        Thread.sleep(10000);
    }

    class ThreadSafeRunnable implements Runnable {

        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + ThreadSafeSingleton.getSingleton());
            }
        }
    }
}

```
## 优点
- 减少内存开支
当一个对象频繁的创建和销毁，并且创建和销毁性能无法优化，单例模式的优势就非常明显。
- 减少性能开支
当产生一个对象需要较多的资源时，如读取配置文、产生其他依赖对象时，等
- 避免对资源的多重占用
例如对文件的操作
- 可设置全局访问点

## 缺点
- 无接口，扩展困难
- 对测试不利
- 违反单一职责

## 使用场景
- 生成唯一序列号
- 整个项目需要一个共享访问点、共享数据。例如Web页面计数器。
- 创建对象需要资源过多，例如数据库操作
- 工具类

## 注意事项
- 在高并发情况下，要注意单例模式的线程同步问题。
```java

/**
 * 线程不安全
 */
public class NotThreadSafeSingleton {
    private NotThreadSafeSingleton() {
    }

    private static NotThreadSafeSingleton notThreadSafeSingleton = null;

    public static NotThreadSafeSingleton getSingleton() {
        if (notThreadSafeSingleton == null) {
            notThreadSafeSingleton = new NotThreadSafeSingleton();
        }
        return notThreadSafeSingleton;
    }
    
    /**
     * 线程安全的
     * 懒汉
     * @return NotThreadSafeSingleton
     */
    public static synchronized NotThreadSafeSingleton getThreadSafeSingleton() {
        if (notThreadSafeSingleton == null) {
            notThreadSafeSingleton = new NotThreadSafeSingleton();
        }
        return notThreadSafeSingleton;
    }
}
```
测试类
```java

public class SingletonTests {

    @Test
    public void testNotThreadSafeSingleton() throws InterruptedException {
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();
        new Thread(new NotThreadSafeRunnable()).start();

        Thread.sleep(5000);
    }

    class NotThreadSafeRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + NotThreadSafeSingleton.getSingleton());
            }
        }
    }
}
```
> 解决方法
  可在getSingleton方法前加synchronized关键字，但最优方式还是通用代码中的饿汉方式。

- 单例模式不要实现Cloneable接口

## 拓展
- 有上限的单例模式

## 最佳实践
- 如何避免被垃圾回收
  - 由容器管理单例的生命周期（如Spring）
  - 状态随时记录
  