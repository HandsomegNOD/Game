package tank.fire;

import tank.Bullet;
import tank.Tank;

/**
 * Author 杨冬冬
 * Date 2023/5/20 16:17
 * Desc  默认开发策略，一次只能发射一个子弹
 */
public class DefaultFire implements FireStrategy {

    private static final DefaultFire INSTANCE = new DefaultFire();

    public DefaultFire() {}

    public static DefaultFire getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + t.getWIDTH()/2 - Bullet.getWIDTH()/2;
        int bY = t.getY() + t.getHEIGHT()/2 - Bullet.getHEIGHT()/2;
        new Bullet(bX, bY, t.getDir(),t.getTf(), t.getGroup());
    }
}
