package test.design_patten.fatorymethod;

import org.junit.Test;

/**
 * Author 杨冬冬
 * Date 2023/5/20 17:24
 * Desc
 *
 * 设计模式之工厂模式：
 *      任何可以产生对象的方法或类，都可以称之为工厂
 */
public class MainTest {


    @Test
    public void test1() {
//        Moveable m = new Car();
//        m.go();
        Moveable c = new CarFactory().create();
        c.go();
    }

}
