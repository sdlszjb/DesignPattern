package kisslinux.state.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateRunningState extends StateLiftState {
    @Override
    public void open() {
        System.out.println("什么也不做！");
    }

    @Override
    public void close() {
        System.out.println("什么也不做！");
    }

    @Override
    public void run() {
        System.out.println("电器启动中...");
        System.out.println("电器运行成功！");
    }

    @Override
    public void stop() {
        super.context.setLiftState(StateLiftContext.stopingState);
        super.context.stop();
    }
}
