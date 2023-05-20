package test.design_patten.fatory;

/**
 * Author 杨冬冬
 * Date 2023/5/20 17:40
 * Desc
 * 简单工厂，可扩展不好
 */
public class SimpleVehicleFactory {

    public Car createCar() {
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
