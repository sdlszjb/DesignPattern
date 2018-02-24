package kisslinux.proxy.hard;

/**
 * created by lsk on 2018-02-24 23:47.
 *
 * @author 庄壮壮
 */
public class HardProxyRealSubject implements HardProxySubject {

    private HardProxySubject proxy = null;

    public HardProxyRealSubject() {
//        this.proxy = new ;
    }

    @Override
    public void request() {
        if (this.isProxy()) {
            System.out.println("Request from HardProxyReadSubject.");
        } else {
            System.out.println("Please use proxy to handle this request.");
        }
    }

    /**
     * 找到自己的代理
     * @return
     */
    @Override
    public HardProxySubject getProxy() {
        return proxy;
    }

    /**
     * 检测代理是否可用
     * @return
     */
    private boolean isProxy() {
        return this.proxy != null;
    }
}
