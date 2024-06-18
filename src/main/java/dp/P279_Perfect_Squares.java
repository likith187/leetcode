package dp;

import java.util.Arrays;

public class P279_Perfect_Squares {
	
	private static int[] dp = new int[10000];
	static {
		Arrays.fill(dp, -1);
	}
	
	public int numSquares(int n) {
		if (n <= 3) {
			return n;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int res = n;
		for(int i = 1; i <= n; i++) {
			int temp = i * i;
			if (temp > n) {
				break;
			}
			res = Math.min(res, 1 + numSquares(n - temp));
		}
		dp[n] = res;
		return res;
	}
	
	public static void main(String[] args) {
		var obj = new P279_Perfect_Squares();
		System.out.println(obj.numSquares(12));
	}
}
