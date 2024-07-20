package takeuforward.sorting;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 46, 24, 52, 20, 9, -1, -1, 0, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int c = 0;
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[c++] = arr[left++];
            } else {
                temp[c++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[c++] = arr[left++];
        }
        while (right <= high) {
            temp[c++] = arr[right++];
        }
        for (int j : temp) {
            arr[low++] = j;
        }
    }
}
