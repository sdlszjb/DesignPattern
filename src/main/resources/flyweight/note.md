# 享元模式

## 定义
使用共享对象可有效地支持大量的细粒度的对象。
```java
/**
 * 抽象享元角色
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:34
 */
public abstract class FlyweightFlyweight {

    // 内部状态
    private String intrinsic;

    // 外部状态
    protected final String Extrinsic;

    // 要求享元角色必须接受外部状态
    public FlyweightFlyweight(String extrinsic) {
        Extrinsic = extrinsic;
    }

    // 定义业务操作
    public abstract void operate();

    // 内部状态getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
/**
  * 具体享元角色
  * 该角色应当与外界环境无关
  *
  * @author 庄壮壮 Administrator
  * @since 2018-03-03 14:34
  */
 public class FlyweightConcreteFlyweight extends FlyweightFlyweight {
 
     // 接受外部状态
     public FlyweightConcreteFlyweight(String extrinsic) {
         super(extrinsic);
     }
 
     /**
      * 根据外部状态进行逻辑处理
      */
     @Override
     public void operate() {
         // 业务逻辑
     }
 }

/**
 * 不可共享的享元角色
 *
 * 该对象不存在外部状态或者安全要求（如线程安全），不能使用共享技术的对象
 * 该对象一般不会出现在享元工厂中。
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:34
 */
public class FlyweightUnsharedConcreteFlyweight extends FlyweightFlyweight {
    public FlyweightUnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    /**
     * 根据外部状态进行逻辑处理
     */
    @Override
    public void operate() {

    }
}

/**
 * 享元工厂
 *
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:36
 */
public class FlyweightFactory {

    // 定义一个池对象
    private static Map<String, FlyweightFlyweight> pool = new HashMap<>();

    public static FlyweightFlyweight getFlyweight(String Extrinsic) {
        FlyweightFlyweight flyweight = null;
        if (pool.containsKey(Extrinsic)) {
            System.out.println(Extrinsic + "----直接从池中获取！");
            flyweight = pool.get(Extrinsic);
        } else {
            System.out.println(Extrinsic + "----新建，并放入池中！");
            flyweight = new FlyweightConcreteFlyweight(Extrinsic);
            pool.put(Extrinsic, flyweight);
        }

        return flyweight;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:51
 */
public class FlyweightTests {

    @Test
    public void testClient() {
        for (int i=0; i<10; i++) {
            FlyweightFactory.getFlyweight("key:"+i);
        }
        FlyweightFlyweight flyweight = FlyweightFactory.getFlyweight("key:5");
        flyweight.operate();
    }
}
```

## Example
```java

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:44
 */
public class FlyweightSignInfo {

    private String id;
    private String location;
    private String subject;
    private String postAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:47
 */
public class FlyweightSignInfo4Pool extends FlyweightSignInfo {

    private String key;

    public FlyweightSignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:45
 */
public class FlyweightSignInfoFactory {

    private static Map<String, FlyweightSignInfo> pool = new HashMap<>();

    @Deprecated
    public static FlyweightSignInfo getSignInfo() {
        return new FlyweightSignInfo();
    }

    public static FlyweightSignInfo getSignInfo(String key) {
        FlyweightSignInfo signInfo = null;
        if (!pool.containsKey(key)) {
            System.out.println(key + "----建立对象，并放入池中！");
            signInfo = new FlyweightSignInfo4Pool(key);
            pool.put(key, signInfo);
        } else {
            signInfo = pool.get(key);
            System.out.println(key + "----直接从池中获取!");
        }
        return signInfo;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-03 14:51
 */
public class FlyweightTests {

    @Test
    public void testExample() {
        for (int i=0; i<4; i++) {
            String subject = "科目：" + i;
            for (int j = 0; j<30; j++) {
                String key = subject + "考试地点：" + j;
                FlyweightSignInfoFactory.getSignInfo(key);
            }
        }

        FlyweightSignInfo signInfo = FlyweightSignInfoFactory.getSignInfo("科目：1考试地点：1");
    }
}
```

## 应用
### 优点
- 减少应用程序创建的对象，降低程序内存的占用，增强程序的性能。

### 缺点
- 提高了系统复杂性
- 需要分离外部状态和内部状态
- 外部状态具有固话特性，不应该随内部状态改变而改变

### 使用场景
- 系统中存在大量的相似对象
- 细粒度的对象都具备较接近的外部状态，切内部状态与环境无关，即对象没有特定身份
- 需要缓冲池的场景

## 扩展
### 线程安全
- 享元模式的使用，必然涉及多线程、线程安全相关的问题，要做好线程安全控制。

### 性能
- 尽量使用Java基本类型作为外部状态。
若使用类作为外部状态，必须覆写equals和hashCode方法，

> 虽然可以使用享元模式实现对象池，但这两者还是有比较大的差异。
> 对象池着重在对象的复用上，池中的每个对象是可替换的，而享元模式主要解决共享问题，如何建立多个可共享的细粒度对象是其关注的重点。