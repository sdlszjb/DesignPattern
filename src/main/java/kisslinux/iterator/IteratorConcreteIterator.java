package kisslinux.iterator;

import java.util.Vector;

/**
 * 具体迭代类
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 13:33
 */
public class IteratorConcreteIterator implements IteratorIterator {

    private Vector vector = new Vector();

    // 定义当前游标
    public int cursor = 0;

    public IteratorConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()) {
            result = this.vector.get(this.cursor++);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor == this.vector.size()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 开发系统时，迭代器的删除方法应该完成两个逻辑。
     * 1. 删除当前元素
     * 2. 当前游标指向下一个元素
     * @return boolean
     */
    @Override
    public boolean remove() {
        this.vector.remove(this.cursor);
        return true;
    }
}
