package kisslinux.chain;

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
