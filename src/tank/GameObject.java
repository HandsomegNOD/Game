package tank;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/29 23:27
 * Desc
 */
public abstract class GameObject {

    public int x, y;
    //todo 添加高宽属性

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

}
