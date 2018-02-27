package kisslinux.chain;

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
