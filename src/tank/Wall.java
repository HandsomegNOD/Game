package tank;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/30 22:31
 * Desc
 */
public class Wall extends GameObject {

    private int w, h;

    public Rectangle rec;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rec = new Rectangle(x, y, w, h);
    }


    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, h, w);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
