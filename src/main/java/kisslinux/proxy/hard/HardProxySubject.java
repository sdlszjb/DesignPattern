package kisslinux.proxy.hard;

/**
 * created by lsk on 2018-02-24 23:46.
 *
 * @author 庄壮壮
 */
public interface HardProxySubject {
    public void request();
    public HardProxySubject getProxy();
}
