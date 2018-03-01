package kisslinux.memento;

/**
 * 备忘录管理员角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:22
 */
public class MementoCaretaker {
    private MementoMemento memento;

    public MementoMemento getMemento() {
        return memento;
    }

    public void setMemento(MementoMemento memento) {
        this.memento = memento;
    }
}
