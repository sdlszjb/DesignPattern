package kisslinux.iterator;

import java.util.Vector;

/**
 * 具体容器
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 14:32
 */
public class IteratorConcreteAggregate implements IteratorAggregate {

    private Vector vector = new Vector();

    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {
        this.vector.remove(object);
    }

    @Override
    public IteratorIterator iterator() {
        return new IteratorConcreteIterator(this.vector);
    }
}