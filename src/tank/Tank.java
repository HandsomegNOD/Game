package tank;

import java.awt.*;

public class Tank {

    //定义初始位置
    private int x, y;
    //定义初始方向
    private Dir dir = Dir.UP;

    //定义移动速度
    private static final int SPEED = 10;

    //移动状态
    private boolean moving = false;

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
    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g) {
        //定义一个方块，并移动
        g.fillRect(x, y, 50, 50);

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
}
