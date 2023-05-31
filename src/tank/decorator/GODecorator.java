package tank.decorator;

import tank.GameObject;

import java.awt.*;

/**
 * Author 杨冬冬
 * Date 2023/5/31 22:44
 * Desc
 */
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
