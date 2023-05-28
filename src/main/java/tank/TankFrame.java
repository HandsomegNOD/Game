package tank;

import tank.abstractfacroty.*;
import tank.fire.DefaultFire;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {


    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    //子弹集合
//    List<Bullet> bullets = new ArrayList<>();
    public List<BaseBullet> bullets = new ArrayList<>();
    //敌方集合
//    public List<Tank> badTanks = new ArrayList<>();
    public List<BaseTank> badTanks = new ArrayList<>();
    //爆炸集合
//    List<Explode> explodes = new ArrayList<>();
    public List<BaseExplode> explodes  = new ArrayList<>();


    Tank tank = new Tank(200,200,Dir.UP,this,Group.GOOD);

//    Explode explode = new Explode(100, 100, this);
//    Bullet b = new Bullet(300, 300, Dir.UP);

    public GameFactory gf = new DefaultFactory();
//    public GameFactory gf = new RectFactory();



    public TankFrame() {
        //窗口大小
        setSize(GAME_WIDTH,GAME_HEIGHT);
        //设置窗口大小不可调整
        setResizable(false);
        //标题
        setTitle("tank war");
        //窗口展示
        setVisible(true);

        addKeyListener(new MyKeyListener());

        //设置窗口关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //双缓冲解决窗口闪烁问题
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0, 0, null);
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌方坦克数量:" + badTanks.size(),10, 80);
        g.setColor(c);
        tank.paint(g);
//        b.paint(g);
        //移除子弹时会报错内存泄露--内部迭代器的问题
//        for (Bullet b : bullets) {
//            b.paint(g);
//        }
        //方式一
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //方式二
//        for (Iterator<Bullet> it = bullets.iterator(); it.hasNext();) {
//            Bullet b = it.next();
//            if (b.isLive()) {
//                it.remove();
//            }
//        }

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

//        explode.paint(g);
    }

    //键盘监听事件
    private class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {

            //根据键盘录入进行行进方向
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD  = true;
                    break;
                case KeyEvent.VK_CONTROL:
//                    tank.fire(DefaultFire.getInstance());
                    tank.fire();
                    break;
            }

            setMainTankDir();
        }

        /**
         * 通过接收键盘按键设置移动方向
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD  = false;
                    break;
            }

            setMainTankDir();
        }

        /**
         * 判断是否移动，并调整移动的方向
         */
        private void setMainTankDir() {

            if (!bL && !bR && !bU && ! bD) {
                tank.setMove(false);
            } else {
                tank.setMove(true);

                if (bL) {
                    tank.setDir(Dir.LEFT);
                }
                if (bR) {
                    tank.setDir(Dir.RIGHT);
                }
                if (bU) {
                    tank.setDir(Dir.UP);
                }
                if (bD) {
                    tank.setDir(Dir.DOWN);
                }
            }
        }
    }
}
