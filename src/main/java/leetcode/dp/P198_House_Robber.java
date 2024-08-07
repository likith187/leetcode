package leetcode.dp;

import java.util.Arrays;

public class P198_House_Robber {
	public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return generate(0, dp, nums);
    }

	private int generate(int i, int[] dp, int[] nums) {
		if (i >= nums.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		if (i + 1 == nums.length) {
			dp[i] = nums[i];
		} else {
			dp[i] =Math.max(nums[i] + generate(i + 2, dp, nums), nums[i + 1] + generate(i + 3, dp, nums));
		}
		return dp[i];
	}
	public static void main(String[] args) {
		var obj = new P198_House_Robber();
		System.out.println(obj.rob(new int[] {1,2,3}));
	}
}
