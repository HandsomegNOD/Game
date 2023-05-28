package test.design_patten.strategy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 策略模式：
 *      建立有个策略接口，有多个接口的实现类，通过多态的形式使用实现类
 */

public class Main {

    @Test
    public void test() {
        int[] a = {9,2,3,5,7,1,4};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test2() {
        Cat[] cats = {new Cat(5,5), new Cat(1,1), new Cat(4,4)};
        Sorter sorter = new Sorter();
        sorter.catSort(cats);
        System.out.println(Arrays.toString(cats));
    }

    @Test
    public void test3() {
        Cat[] cats = {new Cat(5,5), new Cat(1,1), new Cat(4,4)};
        Cat[] cat1s = {new Cat(5,5), new Cat(1,1), new Cat(4,4)};
        Sorter<Cat> sorter = new Sorter<>();

        sorter.comparatorSort(cats, new CatHeightCompartor());
        sorter.comparatorSort(cat1s, ((o1, o2) -> {
            if (o1.getHeight() < o2.getHeight()) {
                return -1;
            } else if (o1.getHeight() > o2.getHeight()) {
                return 1;
            } else {
                return 0;
            }
        }));
        System.out.println(Arrays.toString(cats));
        System.out.println("---------------------------");
        System.out.println(Arrays.toString(cat1s));
    }



}
