package kisslinux.absfactory;

/**
 * 抽象产品类 A
 */
public abstract class AbsFactoryProductA {

    public void shareMethod() {
        System.out.println(this.getClass().getSimpleName() + ": A shareMethod.");
    }

    public abstract void doSomething();
}
