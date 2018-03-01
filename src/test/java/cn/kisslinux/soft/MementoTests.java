package cn.kisslinux.soft;

import kisslinux.memento.MementoCaretaker;
import kisslinux.memento.MementoOriginator;
import kisslinux.memento.status.MementoStatusCaretaker;
import kisslinux.memento.status.MementoStatusOriginator;
import org.junit.Test;

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:56
 */
public class MementoTests {

    @Test
    public void testClient() {
        MementoOriginator originator = new MementoOriginator();
        originator.setState("A");

        MementoCaretaker caretaker = new MementoCaretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("B");

        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }

    /**
     * 多状态备忘录 测试类
     */
    @Test
    public void testStatus() {
        MementoStatusOriginator originator = new MementoStatusOriginator();
        MementoStatusCaretaker caretaker = new MementoStatusCaretaker();

        originator.setState1("中国");
        originator.setState2("强盛");
        originator.setState3("繁荣");
        System.out.println("--- 初始 ---");
        System.out.println(originator);

        caretaker.setMemento(originator.createMemento());

        originator.setState1("A");
        originator.setState2("B");
        originator.setState3("C");

        System.out.println("--- 改变 ---");
        System.out.println(originator);

        originator.restoreMemento(caretaker.getMemento());

        System.out.println("--- 恢复 ---");
        System.out.println(originator);
    }
}
