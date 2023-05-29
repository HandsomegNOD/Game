package tank;

import tank.abstractfacroty.BaseExplode;

import java.awt.*;

public class Explode extends GameObject {

    private static int WIDTH = ResourceMgr.explodes[0].getWidth();
    private static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    private boolean living = false;
    GameModel gm = null;

    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            gm.remove(this);
        }
    }

}
