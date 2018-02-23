package cn.kisslinux.soft;

import kisslinux.factory.FactoryConcreteCreator;
import kisslinux.factory.FactoryConcreteProduct1;
import kisslinux.factory.FactoryCreator;
import kisslinux.factory.FactoryProduct;
import kisslinux.factory.singleton.FactorySingleton;
import kisslinux.factory.singleton.FactorySingletonFactory;
import org.junit.Test;

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
