package takeuforward.arrays.easy;

import java.util.Arrays;

public class P07_Move_Zeros_To_End {
    public void moveZeroes(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[c++] = nums[i];
            }
        }
        while (c < nums.length) nums[c++] = 0;
    }

    public static void main(String[] args) {
        var obj = new P07_Move_Zeros_To_End();
        var arr = new int[]{0, 1, 0, 3, 12};
        obj.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
