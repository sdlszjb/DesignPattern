package kisslinux.memento.status;

/**
 * 多状态备忘录管理员角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:22
 */
public class MementoStatusCaretaker {
    private MementoStatusMemento memento;

    public MementoStatusMemento getMemento() {
        return memento;
    }

    public void setMemento(MementoStatusMemento memento) {
        this.memento = memento;
    }
}
