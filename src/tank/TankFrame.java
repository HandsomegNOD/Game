package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank = new Tank(200,200,Dir.UP);

    public TankFrame() {
        //窗口大小
        setSize(800,600);
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

    @Override
    public void paint(Graphics g) {

        tank.paint(g);

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
            }

            setMainTankDir();
        }

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

        private void setMainTankDir() {

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
