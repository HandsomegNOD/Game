package tank;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/13 11:11
 * Desc  子弹类
 */
public class Bullet {

    //速度
    private static final int SPEED = 100;
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

    Rectangle rec = new Rectangle();

    public Bullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rec.x = this.x;
        rec.y = this.y;
        rec.width = WIDTH;
        rec.height = HEIGHT;

        //new一个子弹就放到队列中去
        tf.bullets.add(this);
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
//        Color c = g.getColor();
//        g.setColor(Color.red);
//        g.fillRect(x, y, WIDTH, HEIGHT);
//        g.setColor(c);
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

        //更新rec
        rec.x = this.x;
        rec.y = this.y;

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
//        Rectangle bulletRect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//        Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.getWIDTH(), Tank.getHEIGHT());
        if (rec.intersects(tank.getRec())) {
            tank.die();
            this.die();
            int eX = tank.getX() + tank.getWIDTH() / 2 - Explode.getWIDTH() / 2;
            int eY = tank.getY() + tank.getHEIGHT() / 2 - Explode.getHEIGHT() / 2;
            tf.explodes.add(new Explode(eX, eY, tf));
        }
    }
}
