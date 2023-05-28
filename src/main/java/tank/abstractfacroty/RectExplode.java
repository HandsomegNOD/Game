package tank.abstractfacroty;

import tank.ResourceMgr;
import tank.TankFrame;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/28 17:05
 * Desc
 */
public class RectExplode extends BaseExplode {

    private static int WIDTH = ResourceMgr.explodes[0].getWidth();
    private static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    private boolean living = false;
    TankFrame tf = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
        if (step >= 15) {
            tf.explodes.remove(this);
        }
        g.setColor(c);
    }
}
