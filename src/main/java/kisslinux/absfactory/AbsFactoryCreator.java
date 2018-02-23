package kisslinux.absfactory;

/**
 * 抽象工厂类
 */
public abstract class AbsFactoryCreator {
    // 创建A产品家族
    public abstract AbsFactoryProductA createProductA();
    // 创建B产品家族
    public abstract AbsFactoryProductB createProductB();
}
