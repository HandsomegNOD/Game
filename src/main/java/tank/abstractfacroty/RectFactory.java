package tank.abstractfacroty;

import tank.Dir;
import tank.Group;
import tank.TankFrame;

/**
 * Author 杨冬冬
 * Date 2023/5/28 17:06
 * Desc
 */
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, tf, group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y, dir, tf, group);
    }
}
