package kisslinux.mediator;

/**
 * 同事类接口
 *
 * 以构造函数注入中介者
 */
public abstract class MediatorColleague {
    protected MediatorMediator mediator;

    public MediatorColleague(MediatorMediator mediator) {
        this.mediator = mediator;
    }
}
