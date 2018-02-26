package cn.kisslinux.soft;

import kisslinux.prototype.PrototypeClass;
import kisslinux.prototype.PrototypeDeep;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * created by lsk on 2018-02-26 18:08.
 *
 * @author 庄壮壮
 */
public class PrototypeTests {

    @Test
    public void testClient() {
        List<PrototypeClass> classes = new ArrayList<>();
        PrototypeClass prototypeClass = new PrototypeClass();
        for (int i=0; i<10; i++) {
            try {
                classes.add(prototypeClass.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(prototypeClass);
        for (PrototypeClass c : classes) {
            System.out.println(c);
        }
    }

    @Test
    public void testDeep() throws CloneNotSupportedException {
        System.out.println("---- prototype ----");
        PrototypeDeep deep = new PrototypeDeep();
        deep.addData("a");
        deep.addData("b");
        deep.addData("c");
        deep.addData("d");
        deep.printData();

        System.out.println("---- Deep ----");
        PrototypeDeep deep2 = deep.clone();
        deep2.printData();
    }
}
