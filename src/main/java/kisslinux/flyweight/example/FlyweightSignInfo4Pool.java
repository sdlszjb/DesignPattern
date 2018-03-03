package kisslinux.flyweight.example;

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
