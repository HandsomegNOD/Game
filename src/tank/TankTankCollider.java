package tank;

/**
 * Author 杨冬冬
 * Date 2023/5/30 0:02
 * Desc
 */
public class TankTankCollider implements Collider{


    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRec().intersects(t2.getRec())) {
                t1.back();
                t2.back();
            }
        }
        return true;
    }
}
