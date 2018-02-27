package kisslinux.chain;

/**
 * created by lsk on 2018-02-27 16:10.
 *
 * 结果
 *
 * @author 庄壮壮
 */
public class ChainResponse {

    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public void echoResponse() {
        System.out.println(this.data);
    }
}
