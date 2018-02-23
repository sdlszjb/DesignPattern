package kisslinux.absfactory;

/**
 * 产品等级 1 的工厂实现类
 */
public class AbsFactoryCreator1 extends AbsFactoryCreator {
    // 生产等级为1的A产品
    @Override
    public AbsFactoryProductA createProductA() {
        return new AbsFactoryConcreteProductA1();
    }

    // 生产等级为1的B产品
    @Override
    public AbsFactoryProductB createProductB() {
        return new AbsFactoryConcreteProductB1();
    }
}
