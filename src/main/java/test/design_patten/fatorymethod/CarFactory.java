package test.design_patten.fatorymethod;

/**
 * Author 杨冬冬
 * Date 2023/5/20 17:43
 * Desc
 */
public class CarFactory {

    public Moveable create() {
        return new Car();
    }
}
