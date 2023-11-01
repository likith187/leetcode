package dp;

import java.util.Arrays;

public class P309_Best_Time_To_Sell_Stock_With_Cooldown_Optimized {
	public int maxProfit(int[] prices) {
		int[][] dp = new int[2][prices.length];
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		return generate(0, prices, dp, true);
    }

	private int generate(int index, int[] prices, int[][] dp, boolean buying) {
		if (index >= prices.length) {
			return 0;
		}
		int c = buying ? 0 : 1;
		if (dp[c][index] != -1) {
			return dp[c][index];
		}
		int res = 0;
		if (buying) {
			res = Math.max(generate(index + 1, prices, dp, buying), generate(index + 1, prices, dp, !buying) - prices[index]);
		} else {
			res = Math.max(generate(index + 1, prices, dp, buying), generate(index + 2, prices, dp, !buying) + prices[index]);
		}
		dp[c][index] = res;
		return res;
	}
	
	public static void main(String[] args) {
		var obj = new P309_Best_Time_To_Sell_Stock_With_Cooldown_Optimized();
		System.out.println(obj.maxProfit(new int[] {1,2,3,0,2}));
	}
}
