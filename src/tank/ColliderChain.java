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
    }

    public void add(Collider c) {
        colliders.add(c);
    }
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            colliders.get(i).collide(o1, o2);
            return false;
        }
        return true;
    }

}
