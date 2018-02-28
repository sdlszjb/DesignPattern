# 迭代器模式

## 提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。

> 在Java中，或者其他面向对象语言，迭代器模式基本上已经内置，不需重新开发。

```java
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
```

## 优点
- 迭代器以及成为语言最基础的工具，基本上不需要自己去实现

## 最佳实践
- 如果是Java开发，不用写迭代器了哦~，Java提供的Iterator就足够使用了。