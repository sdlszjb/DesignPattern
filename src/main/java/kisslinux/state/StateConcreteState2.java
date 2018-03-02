package kisslinux.state;

/**
 * created by lsk on 2018-03-02 16:39.
 *
 * 具体状态类 2
 *
 * @author 庄壮壮
 */
public class StateConcreteState2 extends StateState {
    @Override
    public void handle1() {
        // 设置当前状态为state1
        super.context.setCurrentState(StateContext.STATE1);
        // 过渡到state1状态，由Context实现
        super.context.handle1();
    }

    @Override
    public void handle2() {
        // 本状态下必须处理的逻辑
        System.out.println("Running " + this.getClass().getName() + ", Mehtod: " + new Exception().getStackTrace()[0].getMethodName());
    }
}
