package takeuforward.sorting;

import java.util.Arrays;

public class Insertion_Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{13,46,24,52,20,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int t = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = t;
                j--;
            }
        }
    }
}
