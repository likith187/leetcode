package dp;

public class P221_Maximal_Square {
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		int best = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = matrix[i][j] - '0';
				if (i > 0 && j > 0 && dp[i][j] > 0) {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}
				best = Math.max(best, dp[i][j]);
			}
		}
		return best * best;
	}
}
