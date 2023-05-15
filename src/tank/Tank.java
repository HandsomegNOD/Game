package tank;

import java.awt.*;

/**
 * 坦克类
 */

public class Tank {

    //定义初始位置
    private int x, y;
    //定义初始方向
    private Dir dir = Dir.UP;
    //定义移动速度
    private static final int SPEED = 10;
    //移动状态
    private boolean moving = false;

    private TankFrame tf;

    public boolean isMove() {
        return moving;
    }

    public void setMove(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    //构造器
    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        //定义一个方块，并移动
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        g.setColor(c);

        move();

    }

    /**
     * 移动
     */
    public void move() {
        if (!moving) {
            return;
        }

        //根据方向进行移动
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

    }

    /**
     * 发射子弹
     */
    public void fire() {
        tf.bullets.add(new Bullet(x, y, dir,tf));
    }
}
