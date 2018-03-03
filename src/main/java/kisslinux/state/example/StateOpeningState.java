package kisslinux.state.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:31
 */
public class StateOpeningState extends StateLiftState {
    @Override
    public void open() {
        System.out.println("电梯开启中...");
        System.out.println("电梯开启成功！");
    }

    @Override
    public void close() {
        super.context.setLiftState(StateLiftContext.closingState);
        super.context.close();
    }

    @Override
    public void run() {
        System.out.println("什么也不做！");
    }

    @Override
    public void stop() {
        System.out.println("什么也不做！");
    }
}
