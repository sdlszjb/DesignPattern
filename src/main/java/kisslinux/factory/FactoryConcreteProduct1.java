package kisslinux.factory;

/**
 * 具体产品类 1
 */
public class FactoryConcreteProduct1 extends FactoryProduct {
    @Override
    public void method2() {
        System.out.println(this.getClass().getSimpleName() + ": this is method 2");
    }
}
