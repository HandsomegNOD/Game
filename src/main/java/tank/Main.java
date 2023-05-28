package tank;


public class Main {

    public static void main(String[] args) {

        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));

        for (int i = 0; i < initTankCount; i++) {
//            tf.badTanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tf, Group.BAD));
            tf.badTanks.add(tf.gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD,tf));
        }

        //窗口自动刷新
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }

    }
}
