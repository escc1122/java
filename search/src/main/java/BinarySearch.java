import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        System.out.println(Arrays.toString(arr));
        binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println("==========================");
        binarySearch(arr, 0, arr.length - 1, 333);
    }

    /**
     * @param arr       陣列
     * @param left      左邊的索引
     * @param right     右邊的索引
     * @param findValue 要搜尋的值
     * @return 如果找到就返回索引, 如果沒找到就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        int middle = (left + right) / 2;
        int middleValue = arr[middle];
        // 當 left > right 代表遞迴整個陣列但是沒有找到
        if (left > right) {
            System.out.println("找不到");
            return -1;
        }

        if (findValue > middleValue) { // 向右遞迴
            System.out.printf("findValue=%d middle=%d middleValue=%d left=%d right=%d %s", findValue, middle,
                              middleValue, left, right, "向右繼續");
            System.out.println("");
            return binarySearch(arr, middle + 1, right, findValue);
        } else if (findValue < middleValue) {
            System.out.printf("findValue=%d middle=%d middleValue=%d left=%d right=%d %s", findValue, middle,
                              middleValue, left, right, "向左繼續");
            System.out.println("");
            return binarySearch(arr, left, middle - 1, findValue);
        } else {
            System.out.printf("findValue=%d middle=%d middleValue=%d left=%d right=%d %s", findValue, middle,
                              middleValue, left, right, "get");
            System.out.println("");
            return middle;
        }

    }

}
