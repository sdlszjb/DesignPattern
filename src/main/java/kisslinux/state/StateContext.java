package kisslinux.state;

/**
 * created by lsk on 2018-03-02 16:43.
 * 环境角色
 * @author 庄壮壮
 */
public class StateContext {
    // 定义状态
    public static final StateState STATE1 = new StateConcreteState1();
    public static final StateState STATE2 = new StateConcreteState2();

    // 当前状态
    private StateState currentState;

    // 设置当前的状态
    public void setCurrentState(StateState currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    // 行为委托
    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
