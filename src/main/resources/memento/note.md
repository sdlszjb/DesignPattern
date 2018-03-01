# 备忘录模式

## 定义
在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态。


```java
/**
 * 发起人角色
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:21
 */
public class MementoOriginator {
    // 内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 创建一个备忘录
    public MementoMemento createMemento() {
        return new MementoMemento(this.state);
    }

    // 恢复一个备忘录
    public void restoreMemento(MementoMemento memento) {
        this.setState(memento.getState());
    }
}

/**
 * 备忘录角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:21
 */
public class MementoMemento {
    private String state = "";

    public MementoMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * 备忘录管理员角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:22
 */
public class MementoCaretaker {
    private MementoMemento memento;

    public MementoMemento getMemento() {
        return memento;
    }

    public void setMemento(MementoMemento memento) {
        this.memento = memento;
    }
}
```

## 应用
- 在使用过程中，基本上都会使用标准备忘录模式的变换处理模式。
### 使用场景
- 需要保存和恢复数据的相关状态场景。
- 提供一个可以回滚的操作。
- 需要监控的副本场景。
- 数据库连接的事务管理就是使用的备忘录模式。

### 注意事项
- 备忘录的生命期
备忘录创建出来就要在“最近”的代码中使用，要主动管理它的生命周期，建立就要使用，不使用就要立即删除引用，等待垃圾回收器对他的回收处理。

- 备忘录的性能
不要在频繁建立备份的场景中使用备忘录模式
  - 控制不了备忘录建立的对象数量
  - 大对象的建立是需要消耗资源的

## 扩展
### clone方式的备忘录
### 多状态的备忘录模式
```java
/**
 * 多状态 发起人角色
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:01
 */
public class MementoStatusOriginator {
    private String state1 = "";
    private String state2 = "";
    private String state3 = "";

    // 创建一个备忘录
    public MementoStatusMemento createMemento() {
        return new MementoStatusMemento(MementoStatusBeanUtils.backupProp(this));
    }

    // 恢复一个备忘录
    public void restoreMemento(MementoStatusMemento memento) {
        MementoStatusBeanUtils.restoreProp(this, memento.getStateMap());
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getState3() {
        return state3;
    }

    public void setState3(String state3) {
        this.state3 = state3;
    }

    @Override
    public String toString() {
        return "state1=" + state1 +"\nstate2=" + state2 + "\nstate3=" + state3;
    }
}

/**
 * 属性 工具类
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:02
 */
public class MementoStatusBeanUtils {

    public static Map<String, Object> backupProp(Object bean) {
        Map<String, Object> result = new HashMap<>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                String fieldName = descriptor.getName();
                Method getter = descriptor.getReadMethod();
                Object fieldValue = getter.invoke(bean);

                if (!fieldName.equalsIgnoreCase("class")) {
                    result.put(fieldName, fieldValue);
                }
            }
        } catch (IntrospectionException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void restoreProp(Object bean, Map<String, Object> propMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                String fieldName = descriptor.getName();
                if (propMap.containsKey(fieldName)) {
                    Method setter = descriptor.getWriteMethod();
                    setter.invoke(bean, propMap.get(fieldName));
                }
            }
        } catch (IntrospectionException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 多状态 备忘录角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:02
 */
public class MementoStatusMemento {
    // 接收Map作为状态
    private Map<String, Object> stateMap;

    // 接受一个对象，建立一个备份
    public MementoStatusMemento(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}

/**
 * 多状态备忘录管理员角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:22
 */
public class MementoStatusCaretaker {
    private MementoStatusMemento memento;

    public MementoStatusMemento getMemento() {
        return memento;
    }

    public void setMemento(MementoStatusMemento memento) {
        this.memento = memento;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 15:56
 */
public class MementoTests {
    
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
```
- 通过这种方式的改造，可以备份对象的所有属性。

> 要设计一个在运行期决定备份状态的框架，建议采用AOP框架实现，避免采用动态代理无谓地增加程序逻辑复杂性。

### 多备份的备忘录
```java


/**
 * 支持多备份点的 备份管理类
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 19:25
 */
public class MementoStatusComplexCaretaker {
    // 容纳备忘录的容器
    private Map<String, MementoStatusMemento> mementoMap = new HashMap<>();
    public MementoStatusMemento getMemento(String idx) {
        return mementoMap.get(idx);
    }

    public void setMementoMap(String idx, MementoStatusMemento memento) {
        this.mementoMap.put(idx, memento);
    }
}
```
> 这种模式备份一旦产生就装入内存，没有任何销毁的意向，是非常危险的，注意OOM。使用时，建议增加Map上限。

### 封装得更好一点
- 保证备份的密封性
  - 提供公开的Memento接口
  - 将真实的Memento类放到Originator类中，作为private

