package leetcode.dp;

import java.util.Arrays;

public class P300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		int ans = 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		for (int i = 0; i < nums.length; i++) {
			ans = Math.max(ans, generate(i, nums, dp));
		}
		return ans;
	}

	private int generate(int i, int[] nums, int[] dp) {
		if (i >= nums.length) {
			return 1;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int res = 1;
		for (int j = i + 1 ; j < nums.length; j++) {
			if (nums[i] < nums[j]) {
				res = Math.max(res, 1 + generate(j, nums, dp));
			}
		}
		dp[i] = res;
		return res;
	}
	
	public static void main(String[] args) {
		var obj = new P300_Longest_Increasing_Subsequence();
		System.out.println(obj.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
	}
}
