package takeuforward.sorting;

import java.util.Arrays;

public class Recursive_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 46, 24, 52, 20, 9, -1, -1, 0, 2};
        sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int i) {
        if (i >= arr.length) return;
        boolean swapped = false;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                swapped = true;
            }
        }
        if (swapped) sort(arr, i + 1);
    }
}
