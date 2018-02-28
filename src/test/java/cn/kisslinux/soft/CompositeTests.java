package cn.kisslinux.soft;

import kisslinux.composite.CompositeComponent;
import kisslinux.composite.CompositeComposite;
import kisslinux.composite.CompositeLeaf;
import org.junit.Test;

/**
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
