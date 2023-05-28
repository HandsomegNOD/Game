package test.design_patten.abstractfactory;

/**
 * Author 杨冬冬
 * Date 2023/5/28 14:27
 * Desc
 */
public class MagicFactory extends AbstractFactory {


    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
