package kisslinux.chain;

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
