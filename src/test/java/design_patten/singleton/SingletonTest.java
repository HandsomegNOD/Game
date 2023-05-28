package design_patten.singleton;

import org.junit.Test;

/**
 * 单例模式：
 *      1.饿汉式：类加载到内存后就实例化一个单例，JVM保证线程安全，缺点是不管用到与否，类装载是就完成实例化
 *      2.通过静态代码块的方式初始化，同上
 *      3.懒汉式：什么时候用到什么时候初始化，达到了按需初始化的目的，但是带来了线程不安全
 *      4.在懒汉式的基础上通过加锁（synchronized）的方式保证线程安全
 *      5.if和锁（synchronized）没有同时判断，无法保证线程安全
 *      6.if+锁(synchronized)+if双重判断保证线程安全
 *      7.静态内部类方式，由JVM保证实例化一个单例，加载外部类时不会加载内部类，实现懒加载
 *      8.枚举单例，可以解决线程同步，还可以防止反序列化
 */
public class SingletonTest {

    /**
     * 饿汉式--线程安全
     */
    @Test
    public void test1() {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }

    /**
     * 饿汉式--通过静态代码块初始化
     */
    @Test
    public void test2() {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }

    /**
     * 懒汉式--线程不安全
     */
    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 懒汉式--通过synchronized保证线程安全
     */
    @Test
    public void test4() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 懒汉式--if和synchronized判断不同步无法保证线程不安全
     */
    @Test
    public void test5() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 懒汉式--if+锁(synchronized)+if双重判断保证线程安全
     */
    @Test
    public void test6() {
        for (int i = 0; i < 100; i++) {
            new Thread( () -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 由JVM保证实例化一个单例，加载外部类时不会加载内部类，实现懒加载
     */
    @Test
    public void test7() {
        for (int i = 0; i < 100; i++) {
            new Thread( () -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 枚举单例，可以解决线程同步，还可以防止反序列化
     */
    @Test
    public void test8() {
        for (int i = 0; i < 100; i++) {
            new Thread( () -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }






}
