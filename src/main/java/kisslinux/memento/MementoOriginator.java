package kisslinux.memento;

/**
 * 发起人角色
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:21
 */
public class MementoOriginator {
    // 内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 创建一个备忘录
    public MementoMemento createMemento() {
        return new MementoMemento(this.state);
    }

    // 恢复一个备忘录
    public void restoreMemento(MementoMemento memento) {
        this.setState(memento.getState());
    }
}
