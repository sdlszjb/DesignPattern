package kisslinux.factory;

/**
 * 抽象产品类
 */
public abstract class FactoryProduct {

    public void method1() {
        System.out.println("this is method 1.");
    }

    public abstract void method2();
}
