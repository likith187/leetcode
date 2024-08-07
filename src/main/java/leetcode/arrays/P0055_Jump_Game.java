package leetcode.arrays;

public class P0055_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        if (nums[0] == 0) return false;
        int max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max - 1, nums[i]);
            if (max <= 0) {
                return false;
            }
        }
        return true;
    }
}
