import java.util.Arrays;

import util.MagicRandom;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = MagicRandom.randomIntegerArray(1, 30, 5);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                {
                    minIndex = j; //将最小数的索引保存
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            System.out.println();
            System.out.printf("i=%d minIndex=%d %s", i, minIndex, Arrays.toString(array));
        }
    }
}
