package tank.abstractfacroty;

import tank.Tank;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/21 16:27
 * Desc
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);


    public abstract void collideWith(BaseTank t);
}
