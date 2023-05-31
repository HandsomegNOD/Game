package tank;

/**
 * Author 杨冬冬
 * Date 2023/5/30 23:05
 * Desc
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Wall) {

            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if (t.getRec().intersects(w.rec)) {
                t.back();
            }
        }
        return true;
    }
}
