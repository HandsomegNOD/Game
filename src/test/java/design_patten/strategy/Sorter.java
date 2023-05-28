package design_patten.strategy;

public class Sorter<T> {

    /**
     * 对数组进行排序
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr,i,minPos);

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对猫类型排序
     * @param arr
     */
    public static void catSort(Cat[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
//                minPos = arr[j] < arr[minPos] ? j : minPos;
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            catSwap(arr,i,minPos);

        }
    }

    public static void catSwap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * comparable接口的实现类排序
     * @param arr
     */
    public static void compareSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            compareSwap(arr,i,minPos);

        }
    }

    public static void compareSwap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * comparator接口的实现类排序
     * @param arr
     */
    public void comparatorSort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
//                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            comparatorSwap(arr,i,minPos);

        }
    }

    public void comparatorSwap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
