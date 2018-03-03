package cn.kisslinux.soft;

import kisslinux.state.StateConcreteState1;
import kisslinux.state.StateContext;
import kisslinux.state.example.StateLiftContext;
import org.junit.Test;

/**
 * created by lsk on 2018-03-02 16:52.
 *
 * @author 庄壮壮
 */
public class StateTests {

    @Test
    public void testClient() {
        StateContext context = new StateContext();
        context.setCurrentState(new StateConcreteState1());

//        context.handle1();
//        context.handle2();
        context.handle2();
    }

    @Test
    public void testExample() {
        StateLiftContext context = new StateLiftContext();
        context.setLiftState(StateLiftContext.closingState);

        context.open();
        context.close();
        context.open();
        context.run();
        context.stop();
        context.close();
        context.run();
        context.stop();
        context.run();
        context.stop();
        context.open();
    }
}
