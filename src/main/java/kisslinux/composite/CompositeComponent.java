package kisslinux.composite;

import java.util.List;

/**
 * 抽象构件类
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 15:47
 */
public abstract class CompositeComponent {

    protected String tag = null;

    protected CompositeComponent parent = null;

    public CompositeComponent(String tag) {
        this.tag = tag;
    }

    // 整体和个体都具有的共享
    public void doSomething() {
        System.out.println(this.tag + ": doSomething.");
    }

    // 增加一个叶子构件或树枝构件
    public abstract void add(CompositeComponent component);

    // 删除一个叶子构件或树枝构件
    public abstract void remove(CompositeComponent component);

    // 获得分支下的所有叶子构件和树枝构件
    public abstract List<CompositeComponent> getChildren();

    // 设置父节点
    public void setParent(CompositeComponent parent) {
        this.parent = parent;
    }

    // 获取父节点
    public CompositeComponent getParent() {
        return this.parent;
    }
}
