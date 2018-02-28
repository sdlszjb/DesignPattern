package kisslinux.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
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
