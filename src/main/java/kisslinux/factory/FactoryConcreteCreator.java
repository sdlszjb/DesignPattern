package kisslinux.factory;

/**
 * 具体工厂类
 */
public class FactoryConcreteCreator extends FactoryCreator {


    @Override
    @SuppressWarnings("unchecked")
    public <T extends FactoryProduct> T createProduct(Class<T> c) {
        FactoryProduct product = null;

        try {
            product = (FactoryProduct) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) product;
    }
}
