package test.design_patten.strategy;

/**
 * Author 杨冬冬
 * Date 2023/5/20 9:28
 * Desc
 *  通过实现comparable接口实现比较，
 *      可以将参数类型设置为object，在实现类中进行类型强制转换实现比较。
 *      可以在将接口定义为包含泛型的接口，实现类型通过泛型类型进行判断。
 */

/**
 * 将参数是指为object
 */
//public interface Comparable {
//
//    int compareTo(Object o);
//}


/**
 * 通过泛型完成实现类比较
 * @param <T>
 */
public interface Comparable<T> {
    int compareTo(T o);
}