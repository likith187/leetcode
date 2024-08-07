package leetcode.dp;

public class P45_JumpGame2 {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return jump(0, nums, dp);
    }

    public int jump(int i, int[] nums, int[] dp) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE - 1000;
        for(int j = 1; j <= nums[i]; j++) {
            min = Math.min(min, 1 + jump(i + j, nums, dp));
        }
        dp[i] = min;
        return min;
    }
    
    public int jump2(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < n-1; i++) {
            end = Math.max(end, i + nums[i]);
            if (i == 0 || farthest == i) {
                jumps++;
                farthest = end;
            }
        }
        return jumps;
    }
}
