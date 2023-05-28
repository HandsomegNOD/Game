package design_patten.abstractfactory;

import org.junit.Test;

/**
 * Author 杨冬冬
 * Date 2023/5/28 11:52
 * Desc
 */
public class MainTest {

    @Test
    public void test1() {
        Car c = new Car();
        c.go();
    }

    @Test
    public void test2() {
        Car c = new Car();
        c.go();
        AK47 a = new AK47();
        a.shoot();
        Bread b = new Bread();
        b.printName();
    }

    @Test
    public void test3() {
        Broom b = new Broom();
        b.go();
        MagicStick m = new MagicStick();
        m.shoot();
        MushRoom mr = new MushRoom();
        mr.printName();
    }

    @Test
    public void test4() {
        MondernFactory mf = new MondernFactory();
        Food f = mf.createFood();
        Vehicle v = mf.createVehicle();
        Weapon c = mf.createWeapon();

        c.shoot();
        v.go();
        f.printName();
    }
}
