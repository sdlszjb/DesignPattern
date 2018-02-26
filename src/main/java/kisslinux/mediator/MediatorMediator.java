package kisslinux.mediator;

/**
 * 抽象中介者类
 */
public abstract class MediatorMediator {

    // 定义同事类
    protected MediatorConcreteColleague1 colleague1;
    protected MediatorConcreteColleague2 colleague2;

    public MediatorConcreteColleague1 getColleague1() {
        return colleague1;
    }

    public void setColleague1(MediatorConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public MediatorConcreteColleague2 getColleague2() {
        return colleague2;
    }

    public void setColleague2(MediatorConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public abstract void doSomething1();
    public abstract void doSomething2();
}
