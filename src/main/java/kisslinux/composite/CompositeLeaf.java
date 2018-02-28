package kisslinux.composite;

import java.util.List;

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
