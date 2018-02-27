# 责任链模式

## 定义
使多个对象都由机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

```java

/**
 * created by lsk on 2018-02-27 16:11.
 *
 * 责任链节点等级
 *
 * @author 庄壮壮
 */
public enum ChainLevel {
    ONE(1),
    TWO(2),
    THREE(3);

    private int level;

    ChainLevel(int level) {
        this.level = level;
    }
}

/**
 * created by lsk on 2018-02-27 16:11.
 *
 * 请求
 *
 * @author 庄壮壮
 */
public class ChainRequest {

    private ChainLevel level = ChainLevel.ONE;

    public void setLevel(ChainLevel level) {
        this.level = level;
    }

    public ChainLevel getRequestLevel() {
        return this.level;
    }
}

/**
 * created by lsk on 2018-02-27 16:10.
 *
 * 结果
 *
 * @author 庄壮壮
 */
public class ChainResponse {

    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public void echoResponse() {
        System.out.println(this.data);
    }
}

/**
 * created by lsk on 2018-02-27 16:10.
 *
 * 抽象 责任链 调度类
 *
 * @author 庄壮壮
 */
public abstract class ChainHandler {

    private ChainHandler nextHandler;

    /**
     * 每个处理者都必须对请求做出处理
     * @param request ChainRequest
     * @return ChainResponse
     */
    public final ChainResponse handleMessage(ChainRequest request) {
        ChainResponse response = null;

        // 判断是否时自己的处理级别
        System.out.println(this.getClass().getName() + " is checking handler level...");
        if (this.getHandleLevel().equals(request.getRequestLevel())) {
            System.out.println("Handler request in: " + this.getHandleLevel());
            response = this.handler(request);
        } else {
            if (this.nextHandler != null) {
                System.out.println("Passing request to: " + nextHandler.getHandleLevel());
                response = this.nextHandler.handleMessage(request);
            } else {
                // TODO 没有合适处理者，执行其他逻辑
            }
        }

        return response;
    }

    /**
     * 设置下一个处理者是谁
     * @param handler ChainHandler
     */
    public void setNext(ChainHandler handler) {
        this.nextHandler = handler;
    }

    /**
     * 每个处理者都有一个处理级别
     * @return ChainLevel
     */
    protected abstract ChainLevel getHandleLevel();

    /**
     * 每个处理者都必须实现处理任务
     * @param request ChainRequest
     * @return ChainResponse
     */
    protected abstract ChainResponse handler(ChainRequest request);
}

/**
 * created by lsk on 2018-02-27 16:21.
 *
 * 具体 责任链 节点One
 *
 * @author 庄壮壮
 */
public class ChainHandlerOne extends ChainHandler {
    @Override
    protected ChainLevel getHandleLevel() {
        return ChainLevel.ONE;
    }

    @Override
    protected ChainResponse handler(ChainRequest request) {
        ChainResponse response = new ChainResponse();
        response.setData("Response for ChainLevel: " + request.getRequestLevel());
        return response;
    }
}

/**
 * created by lsk on 2018-02-27 16:21.
 *
 * 具体 责任链 节点Two
 *
 * @author 庄壮壮
 */
public class ChainHandlerTwo extends ChainHandler {
    @Override
    protected ChainLevel getHandleLevel() {
        return ChainLevel.TWO;
    }

    @Override
    protected ChainResponse handler(ChainRequest request) {
        ChainResponse response = new ChainResponse();
        response.setData("Response for ChainLevel: " + request.getRequestLevel());
        return response;
    }
}

/**
 * created by lsk on 2018-02-27 16:21.
 *
 * 具体 责任链 节点Three
 *
 * @author 庄壮壮
 */
public class ChainHandlerThree extends ChainHandler {
    @Override
    protected ChainLevel getHandleLevel() {
        return ChainLevel.THREE;
    }

    @Override
    protected ChainResponse handler(ChainRequest request) {
        ChainResponse response = new ChainResponse();
        response.setData("Response for ChainLevel: " + request.getRequestLevel());
        return response;
    }
}

/**
 * created by lsk on 2018-02-27 16:26.
 *
 * 使用场景类
 * 
 * @author 庄壮壮
 */
public class ChainTests {

    @Test
    public void testClient() {
        ChainHandler handlerOne = new ChainHandlerOne();
        ChainHandler handlerTwo = new ChainHandlerTwo();
        ChainHandler handlerThree = new ChainHandlerThree();

        handlerOne.setNext(handlerTwo);
        handlerTwo.setNext(handlerThree);

        ChainRequest request = new ChainRequest();
        request.setLevel(ChainLevel.THREE);
        ChainResponse response = handlerOne.handleMessage(request);
        response.echoResponse();
    }
}
```

## 优点
- 将请求和处理分开。请求者不必知道谁是处理者，处理者可以不用知道请求的全貌，两者解耦，提高系统灵活性。

## 缺点
- 性能问题
- 调试不方便

## 注意事项
- 为避免出现超长链，一般在Handler中设置一个最大节点数量，若超过阀值，则不允许该链的建立，避免破坏系统性能。

## 最佳实践
- Handler时抽象类，融合了模板方法模式。父类实现请求传递功能，子类实现请求的处理。
- 使用场景挺多。。。例如审批流程。