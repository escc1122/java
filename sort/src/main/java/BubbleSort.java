import java.util.Arrays;

import util.MagicRandom;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = MagicRandom.randomIntegerArray(1, 30, 10);
        System.out.println(Arrays.toString(array));
        final int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                System.out.println();
                System.out.printf("i=%d j=%d %s",i,j,Arrays.toString(array));
            }
        }
    }
}
