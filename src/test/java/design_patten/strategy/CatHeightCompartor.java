package design_patten.strategy;

/**
 * Author 杨冬冬
 * Date 2023/5/20 15:35
 * Desc
 */
public class CatHeightCompartor implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {

        if (o1.getHeight() > o2.getHeight()) {
            return -1;
        } else if (o1.getHeight() < o2.getHeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
