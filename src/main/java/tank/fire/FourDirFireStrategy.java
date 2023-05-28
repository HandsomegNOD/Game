package tank.fire;

import tank.Bullet;
import tank.Dir;
import tank.Tank;

/**
 * Author 杨冬冬
 * Date 2023/5/20 16:37
 * Desc  连续开火策略，一次可以发射三个子弹
 */
public class FourDirFireStrategy implements FireStrategy {


    @Override
    public void fire(Tank t) {
        int bX = t.getX() + t.getWIDTH()/2 - Bullet.getWIDTH()/2;
        int bY = t.getY() + t.getHEIGHT()/2 - Bullet.getHEIGHT()/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
//            new Bullet(bX, bY, dir,t.getTf(), t.getGroup());
            t.getTf().gf.createBullet(bX, bY, dir, t.getGroup(), t.getTf());
        }
    }
}
