package tank;

import java.awt.*;
import java.util.Random;

/**
 * 坦克类
 */

public class Tank {

    //定义初始位置
    private int x, y;
    //宽度和高度
    private static int WIDTH = ResourceMgr.goodTankU.getWidth();
    private static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    //定义初始方向
    private Dir dir = Dir.UP;
    //定义移动速度
    private static final int SPEED = 10;
    //移动状态
    private boolean moving = true;
    //存活状态
    private boolean living = true;
    //分组
    private Group group = Group.BAD;
    //随机移动
    private Random random = new Random();

    private TankFrame tf;

    //定义碰撞检测所需矩形
    Rectangle rec = new Rectangle();

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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRec() {
        return rec;
    }

    //构造器
    public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rec.x = this.x;
        rec.y = this.y;
        rec.width = WIDTH;
        rec.height = HEIGHT;
    }


    public void paint(Graphics g) {

        //判断存活状态
        if (!living) {
            tf.badTanks.remove(this);
        }
        //定义一个方块，并移动
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
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

        //随机发射子弹
        if (this.group == Group.BAD && random.nextInt(100) > 95 ) {
            this.fire();
        }
        //敌方坦克随机移动
        if (this.group == Group.BAD && random.nextInt(100) > 95 ) {
            randomDir();
        }

        //边界检测
        boundsCheck();

        //更新rec
        rec.x = this.x;
        rec.y = this.y;
    }

    /**
     * 发射子弹
     */
    //todo 根据不同的方向调整发射位置
    public void fire() {
        int bX = this.x + Tank.getWIDTH()/2 - Bullet.getWIDTH()/2;
        int bY = this.y + Tank.getHEIGHT()/2 - Bullet.getHEIGHT()/2;
        tf.bullets.add(new Bullet(bX, bY, dir,tf, this.group));
    }

    public void die() {
        living = false;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if (this.x < 0) {
            x = 0;
        }
        if (this.y < 30) {
            y = 30;
        }
        if (this.x > TankFrame.GAME_WIDTH - this.WIDTH) {
            this.x = TankFrame.GAME_WIDTH - this.WIDTH;
        }
        if (this.y > TankFrame.GAME_HEIGHT - this.HEIGHT) {
            this.y = TankFrame.GAME_HEIGHT - this.HEIGHT;
        }
    }
}
