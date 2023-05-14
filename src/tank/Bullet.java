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
    private static int WIDTH = 1, HEIGHT = 1;
    //位置
    private int x, y;
    //方向
    private Dir dir;
    //状态
    private boolean live = true;

    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }

        //设置颜色
        Color c = g.getColor();
        g.setColor(Color.red);
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
            live = false;
        }
    }
}
