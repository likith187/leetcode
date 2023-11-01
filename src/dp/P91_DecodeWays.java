package dp;

import java.util.Arrays;

public class P91_DecodeWays {
	public int numDecodings(String s) {
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return calculate(0, s, dp);
	}

	private int calculate(int i, String s, int[] dp) {
		if (i >= s.length()) {
			return 1;
		}
		if (i == s.length() - 1) {
			return s.charAt(i) == '0' ? 0 : 1;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int res = 0;
		if (Integer.valueOf(s.substring(i, i + 1)) > 0) {
			res += calculate(i + 1, s, dp);
		}
		if (Integer.valueOf(s.substring(i, i + 2)) < 27 && Integer.valueOf(s.substring(i, i + 2)) > 9) {
			res += calculate(i + 2, s, dp);
		}
		dp[i] = res;
		return res;
	}

	public static void main(String[] args) {
		P91_DecodeWays obj = new P91_DecodeWays();
		System.out.println(obj.numDecodings("2222222566"));
	}
}
