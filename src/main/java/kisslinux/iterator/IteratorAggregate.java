package kisslinux.iterator;

/**
 * 抽象容器
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 14:30
 */
public interface IteratorAggregate {
    // 增加元素
    public void add(Object object);

    // 减少元素
    public void remove(Object object);

    // 产生迭代器来遍历所有的元素
    public IteratorIterator iterator();
}
