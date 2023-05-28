package design_patten.strategy;

/**
 * Author 杨冬冬
 * Date 2023/5/20 9:50
 * Desc
 */
public interface Comparator<T> {

    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}