package kisslinux.prototype;

/**
 * created by lsk on 2018-02-26 18:02.
 *
 * 原型模式
 *
 * @author 庄壮壮
 */
public class PrototypeClass implements Cloneable {

    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = null;
        prototypeClass = (PrototypeClass) super.clone();
        return prototypeClass;
    }
}
