package kisslinux.chain;

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
