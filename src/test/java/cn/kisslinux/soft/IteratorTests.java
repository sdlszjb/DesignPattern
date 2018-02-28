package cn.kisslinux.soft;

import kisslinux.iterator.IteratorConcreteAggregate;
import kisslinux.iterator.IteratorAggregate;
import kisslinux.iterator.IteratorIterator;
import org.junit.Test;

/**
 * 迭代器测试类
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 14:34
 */
public class IteratorTests {

    @Test
    public void testClient() {
        IteratorAggregate aggregate = new IteratorConcreteAggregate();
        aggregate.add("abc");
        aggregate.add("def");
        aggregate.add("ghi");

        IteratorIterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
