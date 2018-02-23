# 工厂方法模式
## 定义
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到子类。

## 通用代码
```java
/**
 * 抽象产品类
 */
public abstract class FactoryProduct {

    public void method1() {
        System.out.println("this is method 1.");
    }

    public abstract void method2();
}

/**
 * 具体产品类 1
 */
public class FactoryConcreteProduct1 extends FactoryProduct {
    @Override
    public void method2() {
        System.out.println(this.getClass().getSimpleName() + ": this is method 2");
    }
}

/**
 * 具体产品类 2
 */
public class FactoryConcreteProduct2 extends FactoryProduct {
    @Override
    public void method2() {
        System.out.println(this.getClass().getSimpleName() + ": this is method 2");
    }
}

/**
 * 抽象工厂类
 */
public abstract class FactoryCreator {
    
    /**
     * 创建一个产品对象。输入参数可自行设置
     * 通常为String、Enum、Class等。
     * @param c class
     * @param <T> FactoryProduct
     * @return FactoryProduct子类
     */
    public abstract <T extends FactoryProduct> T createProduct(Class<T> c);
}

/**
  * 具体工厂类
  */
 public class FactoryConcreteCreator extends FactoryCreator {
 
 
     @Override
     @SuppressWarnings("unchecked")
     public <T extends FactoryProduct> T createProduct(Class<T> c) {
         FactoryProduct product = null;
 
         try {
             product = (FactoryProduct) Class.forName(c.getName()).newInstance();
         } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
             e.printStackTrace();
         }
 
         return (T) product;
     }
 }
 
 /**
  * 工厂方法测试类
  */
 public class FactoryTests {
 
     @Test
     public void testClient() {
         FactoryCreator creator = new FactoryConcreteCreator();
         FactoryProduct product = creator.createProduct(FactoryConcreteProduct1.class);
         product.method1();
         product.method2();
     }
 }
```

## 优点
- 具有良好封装性，代码结构清晰
- 扩展性好
- 屏蔽产品类
- 典型的解耦框架

## 使用场景
- new一个对象的替代品
- 需要灵活的、可扩展的框架
- 异构项目中
- 测试驱动开发的框架下

## 拓展
1. 缩小为简单工厂模式（也叫做**静态工厂**类）
去掉抽象工厂类，将getProduct设置为静态方法。
静态工厂类扩展困难。
2. 升级为多个工厂类
每个工厂明确自己的职责，创建自己负责的产品类对象。

> 在复杂情况下，一般采用多个工厂的方法，然后增加一个协调类，避免调用者与各个子工厂交流，协调类的作用是封装子工厂类，对高层模块提供统一的访问接口。

3. 代替单例模式
```java

public class FactorySingleton {
    private FactorySingleton() {}

    public void doSomething() {
        System.out.println(this.getClass().getSimpleName() + ": doSomething.");
    }
}
/**
 * 单例工厂
 */
public class FactorySingletonFactory {

    private static FactorySingleton singleton;

    static {
        try {
            // Class c = Class.forName(FactorySingleton.class.getName());
            Class<?> c = FactorySingleton.class;

            // 获得无参构造函数
            Constructor constructor = c.getDeclaredConstructor();
            // 设置无参构造函数是可访问的
            constructor.setAccessible(true);

            // 产生一个实例对象
            singleton = (FactorySingleton) constructor.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static FactorySingleton getSingleton() {
        return singleton;
    }
}

/**
 * 工厂方法测试类
 */
public class FactoryTests {

    @Test
    public void testSingleton() throws InterruptedException {
        new Thread(new SingletonRunnable()).start();
        new Thread(new SingletonRunnable()).start();
        new Thread(new SingletonRunnable()).start();
        new Thread(new SingletonRunnable()).start();
        new Thread(new SingletonRunnable()).start();
        new Thread(new SingletonRunnable()).start();

        Thread.sleep(5000);
    }

    class SingletonRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                FactorySingleton singleton = FactorySingletonFactory.getSingleton();
                System.out.println(Thread.currentThread() + ": " + singleton);
            }
        }
    }
}
```
4. 延迟初始化
> 可在Factory中利用Map生成一个缓存，方便下次调用。
  - 可限制产品类的最大实例化数量
  - 用在对象初始化复杂的情况（线程池）
  
## 最佳实践
工厂方法可以和其他模式混合使用（模板方法、单例、原型等）