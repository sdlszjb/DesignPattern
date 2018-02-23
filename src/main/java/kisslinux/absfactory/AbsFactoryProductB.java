package kisslinux.absfactory;

/**
 * 抽象产品类 B
 */
public abstract class AbsFactoryProductB {

    public void shareMethod() {
        System.out.println(this.getClass().getSimpleName() + ": B shareMethod.");
    }

    public abstract void doSomething();
}
