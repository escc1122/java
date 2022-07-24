import java.util.Arrays;

import util.MagicRandom;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = MagicRandom.randomIntegerArray(1, 30, 10);
        int[] printArray = array.clone();
        System.out.println(Arrays.toString(array));
        int[] sortedArray = quickSort(array, 0, array.length - 1);
        System.out.println("");
        System.out.println("=======================");
        partitionPrint(printArray);
    }

    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            //左邊繼續排
            quickSort(array, start, pivot - 1);
            //右邊繼續排
            quickSort(array, pivot + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int pivotValue = array[pivot];
        swap(array, pivot, end);
        System.out.println();
        System.out.printf("before start=%d end=%d pivotValue=%d %s", start, end, pivotValue, Arrays.toString(array));

        //小的放左邊 大的放右邊 start
        int newPivot = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivotValue) {
                swap(array, i, newPivot);
                newPivot++;
            }
        }
        swap(array, newPivot, end);
        //小的放左邊 大的放右邊 end
        System.out.println();
        System.out.printf("after start=%d end=%d pivotValue=%d newPivot=%d %s", start, end, pivotValue, newPivot,
                          Arrays.toString(array));
        return newPivot;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partitionPrint(int[] array) {
        int start = 0;
        int end = array.length-1;

        int pivot = (int) (start + Math.random() * (end - start + 1));
        int pivotValue = array[pivot];
        swap(array, pivot, end);
        System.out.println();
        System.out.printf("start=%d end=%d pivotValue=%d %s", start, end, pivotValue, Arrays.toString(array));

        //小的放左邊 大的放右邊 start
        int newPivot = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivotValue) {
                swap(array, i, newPivot);
                System.out.println();
                System.out.printf("start=%d end=%d Pivot=%d newPivot=%d i=%d %s", start, end,newPivot,newPivot+1, i,
                                  Arrays.toString(array));
                newPivot++;
            }
        }
        swap(array, newPivot, end);
        System.out.println();
        System.out.printf("start=%d end=%d Pivot=%d %s", start, end, newPivot,
                          Arrays.toString(array));
        //小的放左邊 大的放右邊 end
        return newPivot;
    }
}
