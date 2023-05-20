package test.design_patten.strategy;

/**
 * Author 杨冬冬
 * Date 2023/5/20 9:01
 * Desc
 */
public class Cat implements Comparable<Cat>{

    private int weigth;
    private int height;

    public int getWeigth() {
        return weigth;
    }

    public int getHeight() {
        return height;
    }

    public Cat(int weigth, int height) {
        this.weigth = weigth;
        this.height = height;
    }

    public int compareTo(Cat c) {
        if (this.weigth < c.weigth) return -1;
        else if (this.weigth > c.weigth) return 1;
        else return 0;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "weigth=" + weigth +
                ", height=" + height +
                '}';
    }
}
