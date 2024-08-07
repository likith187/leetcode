package leetcode.dp;

public class P96_UniqueBinaryTrees {
	public int numTrees(int n) {
		n++;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			int res = 0;
			for (int j = 0; j < i; j++) {
				res += dp[j] * dp[i - j - 1];
			}
			dp[i] = res;
		}
		return dp[n - 1];
	}
}
