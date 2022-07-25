public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        System.out.println(seqSearch(arr,10));
        System.out.println(seqSearch(arr,44));
    }
    public static int seqSearch(int[] arr, int value) {
        //逐一比對，發現有相同值就返回索引
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
