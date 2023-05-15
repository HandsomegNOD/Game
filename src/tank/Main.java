package tank;


public class Main {

    public static void main(String[] args) {

        TankFrame tf = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tf.badTanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tf));
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
