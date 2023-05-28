package tank.abstractfacroty;

import tank.Group;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/21 16:24
 * Desc
 */
public abstract class BaseTank {

    public abstract void paint(Graphics g);

    public abstract Group getGroup();

    public abstract Rectangle getRec();

    public abstract void die();

    public abstract int getX();

    public abstract int getWIDTH();

    public abstract int getY();

    public abstract int getHEIGHT();
}
