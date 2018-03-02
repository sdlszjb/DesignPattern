package kisslinux.state;

/**
 * created by lsk on 2018-03-02 16:39.
 *
 * 具体状态类 1
 *
 * @author 庄壮壮
 */
public class StateConcreteState1 extends StateState {
    @Override
    public void handle1() {
        // 本状态下必须处理的逻辑
        System.out.println("Running " + this.getClass().getName() + ", Mehtod: " + new Exception().getStackTrace()[0].getMethodName());
    }

    @Override
    public void handle2() {
        // 设置当前状态为state2
        super.context.setCurrentState(StateContext.STATE2);
        // 过渡到state2状态，由Context实现
        super.context.handle2();
    }
}
