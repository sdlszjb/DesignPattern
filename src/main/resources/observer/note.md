# 观察者模式

## 定义
也叫做 发布/订阅模式（publish/subscribe），定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于他的对象都会得到通知并被自动更新。

```java
/**
 * 观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:52
 */
public interface ObserverObserver {
    public void update(ObserverSubject subject, Object dto);
}

/**
 * 被观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:51
 */
public abstract class ObserverSubject {

    // 定义一个观察者数组
    private Vector<ObserverObserver> observers = new Vector<>();

    // 增加一个观察者
    public void addObserver(ObserverObserver observer) {
        this.observers.add(observer);
    }

    // 删除一个观察者
    public void delObserver(ObserverObserver observer) {
        this.observers.remove(observer);
    }

    // 通知所有观察者
    public void notifyObservers(ObserverSubject subject, Object dto) {
        for (ObserverObserver observer : this.observers) {
            observer.update(subject, dto);
        }
    }
}

/**
 * 具体观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:57
 */
public class ObserverConcreteObserver implements ObserverObserver {
    @Override
    public void update(ObserverSubject subject, Object dto) {
        System.out.printf("received message from :%s, message is: %s\n", subject, dto);
    }
}

/**
 * 具体被观察者
 *
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:56
 */
public class ObserverConcreteSubject extends ObserverSubject {

    public void doSomething() {
        /**
         * do something.
         */
        System.out.println("subject doSomething.");
        super.notifyObservers(this, this.getClass().getSimpleName());
    }
}

/**
 * 观察者模式测试
 * @author 庄壮壮 Administrator
 * @since 2018-02-28 20:59
 */
public class ObserverTests {

    @Test
    public void testClient() {
        ObserverConcreteSubject subject = new ObserverConcreteSubject();
        ObserverObserver observer = new ObserverConcreteObserver();

        subject.addObserver(observer);
        subject.doSomething();
    }
}
```

## 优点
- 观察者与被观察者之间是抽象耦合
无论是增加观察者还是增加被观察者都非常容易扩展，并且Java中已经实现抽象层的定义。
- 建立一套触发机制
观察者模式可以完美地实现一条触发链。

## 缺点
- 较低开发效率和运行效率，一般采用异步的方式

## 使用场景
- 关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系。
- 事件多级触发场景
- 跨系统的信息交换，如：消息队列的处理机制

## 注意事项
- 广播链的问题
在一个观察者模式中，最多出现一个对象既是观察者又是被观察者，也就是说，消息最多转发一次。否则可维护性会非常差。

- 异步处理问题
要考虑线程安全和队列问题。

## 扩展
- Java中已经内置Observer和Observable接口

## 真实的观察者模式
- 观察者与被观察者之间的消息沟通
观察者的update方法接收两个参数，一个是被观察者，一个是DTO。

- 观察者相应方式
  - 同步架构
  - 异步架构
- 被观察者尽量自己做主
建议被观察者增加一个doSomething(boolean isNotifyObs)方法，决定是否通知观察者，而不是在消息到达观察者时才判断是否要消费。

## 订阅发布模型
- RxJava2

## 最佳实践
- 文件系统
例如，在一个目录下建立一个文件，这个动作会通知目录管理器增加该目录，同时磁盘管理器减少1KB...

- 猫鼠游戏
猫叫一声、老鼠跑了、主人醒了

- ATM
- 广播收音机