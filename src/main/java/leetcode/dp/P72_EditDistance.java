package leetcode.dp;

public class P72_EditDistance {
	
	int[][] dp = new int[500][500];
	
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] grid = new int[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			grid[i][0] = i;
		}
		for(int i = 0; i <= n; i++) {
			grid[0][i] = i;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(word1.charAt(i - 1) == word2.charAt(i - 1)) {
					grid[i][j] = grid[i - 1][j - 1];
				} else {
					grid[i][j] = 1 + Math.min(grid[i - 1][j], Math.min(grid[i][j - 1], grid[i - 1][j - 1]));
				}
			}
		}
		return grid[m][n];
	}
	
	public int minDistanceTP(String word1, String word2) {
		return calculate(0, 0, word1, word2);
	}
	
	public int calculate(int i, int j, String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (i == m) {
			return n - j;
		}
		if (j == n) {
			return m - i;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int best = Integer.MAX_VALUE;
		if (s1.charAt(i) == s2.charAt(j)) {
			best = Math.min(best, calculate(i + 1, j + 1, s1, s2));
		}
		best = Math.min(best, calculate(i + 1, j, s1, s2) + 1);
		best = Math.min(best, calculate(i, j + 1, s1, s2) + 1);
		best = Math.min(best, calculate(i + 1, j + 1, s1, s2) + 1);
		dp[i][j] = best;
		return best;
	}
}
