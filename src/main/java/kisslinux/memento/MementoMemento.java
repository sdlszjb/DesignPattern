package kisslinux.memento;

/**
 * 备忘录角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:21
 */
public class MementoMemento {
    private String state = "";

    public MementoMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
