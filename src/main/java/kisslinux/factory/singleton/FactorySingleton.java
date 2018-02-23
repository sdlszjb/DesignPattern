package kisslinux.factory.singleton;

public class FactorySingleton {
    private FactorySingleton() {}

    public void doSomething() {
        System.out.println(this.getClass().getSimpleName() + ": doSomething.");
    }
}
