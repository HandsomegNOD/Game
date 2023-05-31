package tank;

/**
 * Author 杨冬冬
 * Date 2023/5/29 23:49
 * Desc
 */
public class BulletTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.getGroup() == t.getGroup()) {
                return false;
            }

            if (b.rec.intersects(t.getRec())) {
                t.die();
                b.die();
                int eX = t.getX() + t.getWIDTH() / 2 - Explode.getWIDTH() / 2;
                int eY = t.getY() + t.getHEIGHT() / 2 - Explode.getHEIGHT() / 2;
                new Explode(eX, eY);
                return true;
            }
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2,o1);
        }
        return true;
    }
}
