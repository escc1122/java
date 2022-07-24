import java.util.Arrays;

import util.MagicRandom;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = MagicRandom.randomIntegerArray(1, 30, 5);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            int currentValue = array[i + 1];
            int preIndex = i;
            //往前尋找插入點 && 尋找過程所有值向後移位
            while (preIndex >= 0 && currentValue < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                System.out.println();
                System.out.printf("i=%d currentValue=%d %s", i, currentValue, Arrays.toString(array));
                preIndex--;
            }
            //插入
            array[preIndex + 1] = currentValue;
            System.out.println();
            System.out.printf("i=%d currentValue=%d %s", i, currentValue, Arrays.toString(array));
        }
    }
}
