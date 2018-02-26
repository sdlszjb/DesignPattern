package kisslinux.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * created by lsk on 2018-02-26 18:17.
 *
 * 深拷贝
 *
 * @author 庄壮壮
 */
public class PrototypeDeep implements Cloneable {

    private List<String> list = new ArrayList<>();

    @Override
    @SuppressWarnings("unchecked")
    public PrototypeDeep clone() throws CloneNotSupportedException {
        PrototypeDeep deep = null;

        deep = (PrototypeDeep) super.clone();

        deep.list = (List<String>) ((ArrayList<String>)this.list).clone();

        return deep;
    }

    public void addData(String s) {
        this.list.add(s);
    }

    public void printData() {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
