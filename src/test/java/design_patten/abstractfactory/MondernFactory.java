package design_patten.abstractfactory;

/**
 * Author 杨冬冬
 * Date 2023/5/28 14:26
 * Desc
 */
public class MondernFactory extends AbstractFactory {


    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
