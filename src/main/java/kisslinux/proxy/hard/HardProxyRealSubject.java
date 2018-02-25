package kisslinux.proxy.hard;

/**
 * created by lsk on 2018-02-24 23:47.
 *
 * @author 庄壮壮
 */
public class HardProxyRealSubject implements HardProxySubject {

    private HardProxySubject proxy = null;

    public HardProxyRealSubject() {
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
     * @return HardProxySubject
     */
    @Override
    public HardProxySubject getProxy() {
        this.proxy = new HardProxySubjectProxy(this);
        return this.proxy;
    }

    /**
     * 检测代理是否可用
     * 这里的检测方法是很简单的一种
     * 真实案例会校验Proxy的匹配性
     * @return true/false
     */
    private boolean isProxy() {
        return this.proxy != null;
    }
}
