package leetcode.dp;

import java.util.Arrays;

public class P213_House_Robber2 {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp1 = new int[nums.length - 1];
		Arrays.fill(dp1, -1);
		int[] dp2 = new int[nums.length - 1];
		Arrays.fill(dp2, -1);
		return Math.max(generate(0, dp1, Arrays.copyOfRange(nums, 0, nums.length - 1)),
				generate(0, dp2, Arrays.copyOfRange(nums, 1, nums.length)));
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
			dp[i] = Math.max(nums[i] + generate(i + 2, dp, nums), nums[i + 1] + generate(i + 3, dp, nums));
		}
		return dp[i];
	}

	public static void main(String[] args) {
		var obj = new P213_House_Robber2();
		System.out.println(obj.rob(new int[] { 2, 7, 9, 3, 1 }));
	}
}
