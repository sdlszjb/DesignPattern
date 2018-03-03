package kisslinux.state.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:29
 */
public abstract class StateLiftState {
    protected StateLiftContext context;

    public void setContext(StateLiftContext context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
