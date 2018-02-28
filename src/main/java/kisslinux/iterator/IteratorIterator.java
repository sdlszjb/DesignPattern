package kisslinux.iterator;

/**
 * 迭代器接口
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 13:30
 */
public interface IteratorIterator {

    // 遍历到下一个元素
    public Object next();

    // 是否已经遍历到尾部
    public boolean hasNext();

    // 删除当前指定的元素
    public boolean remove();

}
