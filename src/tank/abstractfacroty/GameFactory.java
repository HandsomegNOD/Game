package tank.abstractfacroty;

import tank.Dir;
import tank.GameModel;
import tank.Group;
import tank.TankFrame;

/**
 * Author 杨冬冬
 * Date 2023/5/21 16:21
 * Desc
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm);
    public abstract BaseExplode createExplode(int x, int y, GameModel gm);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, GameModel gm);
}
