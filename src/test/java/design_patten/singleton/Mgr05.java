package design_patten.singleton;



public class Mgr05 {

    private static Mgr05 INSTANCE;
    private Mgr05() {}
    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            INSTANCE = new Mgr05();
        }
        return INSTANCE;
    }
    public void m() {
         System.out.println("m");
     }
}
