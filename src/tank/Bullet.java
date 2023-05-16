package tank;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/13 11:11
 * Desc  子弹类
 */
public class Bullet {

    //速度
    private static final int SPEED = 1;
    //宽度和高度
    private static int WIDTH = ResourceMgr.bulletU.getWidth();
    private static int HEIGHT = ResourceMgr.bulletU.getHeight();

    //位置
    private int x, y;
    //方向
    private Dir dir;
    //状态
    private boolean living = true;
    //分组
    private Group group = Group.BAD;

    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }

        //设置颜色
        Color c = g.getColor();
        g.setColor(Color.red);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();
    }

    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void die() {
        living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return;
        }
        //todo 用一个rect记录子弹的位置
        Rectangle bulletRect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.getWIDTH(), Tank.getHEIGHT());
        if (bulletRect.intersects(tankRect)) {
            tank.die();
            this.die();
            tf.explodes.add(new Explode(x, y, tf));
        }
    }
}
