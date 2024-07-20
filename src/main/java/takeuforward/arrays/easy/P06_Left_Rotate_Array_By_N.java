package takeuforward.arrays.easy;

import java.util.Arrays;

public class P06_Left_Rotate_Array_By_N {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4,5,6,7,8,9};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int n) {
        n = n % arr.length;
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
            low++;
            high--;
        }
    }
}
