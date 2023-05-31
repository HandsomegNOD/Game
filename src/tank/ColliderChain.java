package tank;

import java.util.LinkedList;
import java.util.List;

/**
 * Author 杨冬冬
 * Date 2023/5/30 0:14
 * Desc
 */
public class ColliderChain implements Collider {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
        //todo 子弹和子弹碰撞
    }

    public void add(Collider c) {
        colliders.add(c);
    }
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }

}
