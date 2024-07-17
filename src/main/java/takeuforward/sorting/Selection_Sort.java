package takeuforward.sorting;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{13,46,24,52,20,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index != i) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
            }
        }
    }
}
