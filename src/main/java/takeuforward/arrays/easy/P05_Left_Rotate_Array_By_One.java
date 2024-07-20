package takeuforward.arrays.easy;

import java.util.Arrays;

public class P05_Left_Rotate_Array_By_One {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr) {
        int temp = arr[0];
        for (int i = arr.length - 1; i >= 0; i--) {
            int t = arr[i];
            arr[i] = temp;
            temp = t;
        }
    }
}
