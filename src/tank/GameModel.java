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

    private static final GameModel INSTANCE = new GameModel();

    Tank tank;

    static {
        INSTANCE.init();
    }

    /**
     * 替换了敌方坦克，子弹，爆炸的集合
     */
    private List<GameObject> gos = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public GameModel() {

    }

    //初始化
    private void init() {
        tank = new Tank(200,400, Dir.UP, Group.GOOD);

        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));

        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        add(new Wall(150, 150, 200,50));
        add(new Wall(550, 150, 200,50));
        add(new Wall(300, 300, 50,200));
        add(new Wall(550, 3000, 500,200));
    }


    public void add(GameObject go) {
        this.gos.add(go);
    }

    public void remove(GameObject go) {
        this.gos.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量" + bullets.size(), 10, 60);
//        g.drawString("敌方坦克数量:" + badTanks.size(),10, 80);
        g.setColor(c);
        tank.paint(g);

        /**
         * 不需要分别画出坦克，子弹，爆炸了
         */
        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }

        //碰撞检测-通过比较器实现优化
        for (int i = 0; i < gos.size(); i++) {
            for (int j = i+1; j < gos.size(); j++) {
                GameObject o1 = gos.get(i);
                GameObject o2 = gos.get(j);
//                collider.collider(o1,o2);
                chain.collide(o1,o2);
            }
        }
    }

    public Tank getMainTank() {
        return tank;
    }
}
