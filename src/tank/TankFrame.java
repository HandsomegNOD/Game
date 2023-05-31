package tank;

import tank.abstractfacroty.BaseBullet;
import tank.abstractfacroty.BaseExplode;
import tank.abstractfacroty.DefaultFactory;
import tank.abstractfacroty.GameFactory;
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

    GameModel gm = new GameModel();

    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 720;

    GameFactory gf = new DefaultFactory();



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

        GameModel.getInstance().paint(g);
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
                    GameModel.getInstance().getMainTank().fire();
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
                GameModel.getInstance().getMainTank().setMove(false);
            } else {
                GameModel.getInstance().getMainTank().setMove(true);

                if (bL) {
                    GameModel.getInstance().getMainTank().setDir(Dir.LEFT);
                }
                if (bR) {
                    GameModel.getInstance().getMainTank().setDir(Dir.RIGHT);
                }
                if (bU) {
                    GameModel.getInstance().getMainTank().setDir(Dir.UP);
                }
                if (bD) {
                    GameModel.getInstance().getMainTank().setDir(Dir.DOWN);
                }
            }
        }
    }
}
