package tank.abstractfacroty;

import tank.*;

/**
 * Author 杨冬冬
 * Date 2023/5/21 16:27
 * Desc
 */
public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return null;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return null;
    }
}
