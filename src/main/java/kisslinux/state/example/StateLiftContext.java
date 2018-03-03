package kisslinux.state.example;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 08:30
 */
public class StateLiftContext {
    public final static StateOpeningState openingState = new StateOpeningState();
    public final static StateClosingState closingState = new StateClosingState();
    public final static StateRunningState runningState = new StateRunningState();
    public final static StateStoppingState stopingState = new StateStoppingState();

    private StateLiftState liftState;

    public StateLiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(StateLiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
