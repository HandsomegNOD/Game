package tank;

import tank.abstractfacroty.BaseBullet;
import tank.abstractfacroty.BaseExplode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author 杨冬冬
 * Date 2023/5/29 22:57
 * Desc
 */
public class GameModel {

    Tank tank = new Tank(200,200,Dir.UP,this,Group.GOOD);


    //子弹集合
    List<BaseBullet> bullets = new ArrayList<>();
    //敌方集合
    List<Tank> badTanks = new ArrayList<>();
    //爆炸集合
    List<BaseExplode> explodes  = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));

        for (int i = 0; i < initTankCount; i++) {
            badTanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, this, Group.BAD));
        }
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌方坦克数量:" + badTanks.size(),10, 80);
        g.setColor(c);
        tank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        //画出敌方
        for (int i = 0; i < badTanks.size(); i++) {
            badTanks.get(i).paint(g);
        }

        //画出爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < badTanks.size(); j++) {
                bullets.get(i).collideWith(badTanks.get(j));

            }
        }
    }

    public Tank getMainTank() {
        return tank;
    }
}
