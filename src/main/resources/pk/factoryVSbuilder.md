# 工厂方法VS建造者模式

工厂方法模式注重在整体对象的创建，建造者模式注重的是部件构建的过程，旨在通过一步步地精确构造创建出一个复杂的对象。

### 工厂方法
```java
/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:18
 */
public interface SuperMan {
    public void specialTalent();
}
/**
  * @author 庄壮壮 Administrator
  * @since 2018-03-04 12:19
  */
 public class AdultSuperMan implements SuperMan {
     @Override
     public void specialTalent() {
         System.out.println("大超人力大无穷！");
     }
 }

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:20
 */
public class ChildSuperMan implements SuperMan {
    @Override
    public void specialTalent() {
        System.out.println("小超人刀枪不入！");
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:18
 */
public class SuperManFactory {
    public static SuperMan createSuperMan(String type) {
        switch (type) {
            case "adult":
                return new AdultSuperMan();
            case "child":
                return new ChildSuperMan();
            default:
                return null;
        }
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:22
 */
public class FactoryTests {

    @Test
    public void testClient() {
        SuperMan adultSuperMan = SuperManFactory.createSuperMan("adult");
        if (adultSuperMan != null) {
            adultSuperMan.specialTalent();
        }
    }
}
```

### 建造者模式
```java
/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:25
 */
public class SuperMan {

    private String body;
    private String specialTalent;
    private String specialSymbol;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
        this.specialTalent = specialTalent;
    }

    public String getSpecialSymbol() {
        return specialSymbol;
    }

    public void setSpecialSymbol(String specialSymbol) {
        this.specialSymbol = specialSymbol;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:25
 */
public abstract class Builder {
    protected final SuperMan superMan = new SuperMan();

    public void setBody(String body) {
        this.superMan.setBody(body);
    }

    public void setSpecialTalent(String st) {
        this.superMan.setSpecialTalent(st);
    }

    public void setSpecialSymbol(String ss) {
        this.superMan.setSpecialSymbol(ss);
    }

    public abstract SuperMan getSuperMan();
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:27
 */
public class AdultSuperManBuilder extends Builder {
    @Override
    public SuperMan getSuperMan() {
        super.setBody("强壮的身体");
        super.setSpecialTalent("会飞行");
        super.setSpecialSymbol("大S");
        return super.superMan;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:27
 */
public class ChildSuperManBuilder extends Builder {
    @Override
    public SuperMan getSuperMan() {
        super.setBody("灵活的身体");
        super.setSpecialTalent("刀枪不入");
        super.setSpecialSymbol("小S");
        return super.superMan;
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:29
 */
public class Director {
    private static Builder adultBuilder = new AdultSuperManBuilder();
    private static Builder childBuilder = new ChildSuperManBuilder();

    public static SuperMan getAdultSuperMan() {
        return adultBuilder.getSuperMan();
    }

    public static SuperMan getChildSuperMan() {
        return childBuilder.getSuperMan();
    }
}

/**
 * @author 庄壮壮 Administrator
 * @since 2018-03-04 12:31
 */
public class Client {

    @Test
    public void testClient() {
        SuperMan superMan = Director.getAdultSuperMan();
        System.out.println(superMan.getSpecialTalent());
    }
}
```

### 最佳实践
- 意图不同
  - 工厂方法：关注产品整体
  - 建造模式：依赖各部件的产生以及装配顺序
- 产品复杂度不同
  - 工厂方法：对象粒度比较粗
  - 建造模式：对象粒度比较细

#### 如何选择
若需要关注部件的生产、安装步骤，则选择建造者，否则选择工厂方法。