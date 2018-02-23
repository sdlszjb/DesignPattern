package kisslinux.absfactory;

/**
 * 产品等级为 2 的工厂实现类
 */
public class AbsFactoryCreator2 extends AbsFactoryCreator {
    // 生产等级为2的A产品
    @Override
    public AbsFactoryProductA createProductA() {
        return new AbsFactoryConcreteProductA2();
    }

    // 生产等级为12的B产品
    @Override
    public AbsFactoryProductB createProductB() {
        return new AbsFactoryConcreteProductB2();
    }
}
