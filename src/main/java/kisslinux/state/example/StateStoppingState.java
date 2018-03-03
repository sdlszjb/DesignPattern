package kisslinux.state.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateStoppingState extends StateLiftState {
    @Override
    public void open() {
        super.context.setLiftState(StateLiftContext.openingState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("什么也不做！");
    }

    @Override
    public void run() {
        super.context.setLiftState(StateLiftContext.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止中...");
        System.out.println("电梯停止成功！");
    }
}
