package kisslinux.factory;

/**
 * 抽象工厂类
 */
public abstract class FactoryCreator {

    /**
     * 创建一个产品对象。输入参数可自行设置
     * 通常为String、Enum、Class等。
     * @param c class
     * @param <T> FactoryProduct
     * @return FactoryProduct子类
     */
    public abstract <T extends FactoryProduct> T createProduct(Class<T> c);
}
