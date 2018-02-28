# 组合模式

## 定义
将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用一致性。

```java
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

/**
* 树枝构件
* 
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 18:54
 */
public class CompositeComposite extends CompositeComponent {

    private List<CompositeComponent> components = new ArrayList<>();

    public CompositeComposite(String tag) {
        super(tag);
    }

    @Override
    public void add(CompositeComponent component) {
        component.setParent(this); // 为子节点设置父节点
        this.components.add(component);
    }

    @Override
    public void remove(CompositeComponent component) {
        this.components.remove(component);
    }

    @Override
    public List<CompositeComponent> getChildren() {
        return this.components;
    }
}

/**
 * 叶子构件
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 15:51
 */
public class CompositeLeaf extends CompositeComponent {
    public CompositeLeaf(String tag) {
        super(tag);
    }

    /**
     * 叶子节点不需要该功能
     * 因此声明该方法为Deprecated
     * @param component CompositeComponent
     */
    @Deprecated
    @Override
    public void add(CompositeComponent component) {
        throw new UnsupportedOperationException();
    }

    /**
     * 叶子节点不需要该功能
     * 因此声明该方法为Deprecated
     * @param component CompositeComponent
     */
    @Override
    public void remove(CompositeComponent component) {
        throw new UnsupportedOperationException();
    }

    /**
     * 叶子节点不需要该功能
     * 因此声明该方法为Deprecated
     * @return List
     */
    @Override
    public List<CompositeComponent> getChildren() {
        throw new UnsupportedOperationException();
    }
}

/**
* 测试类
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 18:56
 */
public class CompositeTests {

    @Test
    public void testClient() {
        // 创建一个根节点
        CompositeComponent root = new CompositeComposite("root");
        // 创建一个树枝构件
        CompositeComponent branch = new CompositeComposite("branch");
        // 创建一个叶子节点
        CompositeComponent leaf = new CompositeLeaf("leaf");

        root.add(branch);
        branch.add(leaf);

        display(root);

        System.out.println("------");

        // 数据结构 树的遍历，不太会，得学习一下
        leaf.doSomething();
        leaf.getParent().doSomething();
        leaf.getParent().getParent().doSomething();
    }

    private void display(CompositeComponent root) {
        root.doSomething(); // 执行树节点
        for (CompositeComponent c : root.getChildren()) {
            if (c instanceof CompositeComposite) {
                display(c); // 如果树节点，递归调用
            } else {
                c.doSomething(); // 执行叶子节点
            }
        }
    }
}
```

## 优点
- 高层模块调用简单
高层模块不必关心自己处理的是单个对象还是整个组合结构，简化了高层模块的代码。
- 节点自由增加

## 缺点
- 树枝和树叶均使用实现类，没有面向接口编程，与依赖倒置原则冲突。

## 使用场景
- 维护和展示部分-整体关系的场景，如树形菜单、文件、文件夹管理。
- 从一个整体中能够独立出部分模块或功能的场景。

## 注意事项
- 只要是树形结构，就要考虑使用组合模式。

## 最佳实践
- 组合模式在项目中应用很多，页面、导航、树形菜单、XML