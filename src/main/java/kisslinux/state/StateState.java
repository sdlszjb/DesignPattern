package kisslinux.state;

/**
 * created by lsk on 2018-03-02 16:38.
 *
 * 抽象状态角色
 *
 * @author 庄壮壮
 */
public abstract class StateState {

    // 定义一个环境角色，提供子类访问
    protected StateContext context;

    // 设置环境角色
    public void setContext(StateContext context) {
        this.context = context;
    }

    // 行为
    public abstract void handle1();
    public abstract void handle2();
}
