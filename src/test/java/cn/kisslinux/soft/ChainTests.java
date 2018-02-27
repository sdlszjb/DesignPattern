package cn.kisslinux.soft;

import kisslinux.chain.*;
import org.junit.Test;

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
