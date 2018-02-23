package kisslinux.factory;

/**
 * 具体产品类 2
 */
public class FactoryConcreteProduct2 extends FactoryProduct {
    @Override
    public void method2() {
        System.out.println(this.getClass().getSimpleName() + ": this is method 2");
    }
}
