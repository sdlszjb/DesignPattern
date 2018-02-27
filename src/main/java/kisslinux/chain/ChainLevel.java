package kisslinux.chain;

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
