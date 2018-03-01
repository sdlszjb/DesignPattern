package kisslinux.memento.status;

/**
 * 多状态 发起人角色
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:01
 */
public class MementoStatusOriginator {
    private String state1 = "";
    private String state2 = "";
    private String state3 = "";

    // 创建一个备忘录
    public MementoStatusMemento createMemento() {
        return new MementoStatusMemento(MementoStatusBeanUtils.backupProp(this));
    }

    // 恢复一个备忘录
    public void restoreMemento(MementoStatusMemento memento) {
        MementoStatusBeanUtils.restoreProp(this, memento.getStateMap());
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getState3() {
        return state3;
    }

    public void setState3(String state3) {
        this.state3 = state3;
    }

    @Override
    public String toString() {
        return "state1=" + state1 +"\nstate2=" + state2 + "\nstate3=" + state3;
    }
}
