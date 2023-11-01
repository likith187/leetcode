package dp;

import java.util.Arrays;

public class P309_Best_Time_To_Sell_Stock_With_Cooldown {
	public int maxProfit(int[] prices) {
		int[] dp = new int[prices.length];
		Arrays.fill(dp, -1);
		return generate(0, prices, dp);
    }

	private int generate(int index, int[] prices, int[] dp) {
		if (index >= prices.length) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		int res = 0;
		for(int i = index; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				if (prices[i] < prices[j]) {
					res = Math.max(res, prices[j] - prices[i] + generate(j + 2, prices, dp));
				}
			}
		}
		dp[index] = res;
		return res;
	}
	
	public static void main(String[] args) {
		var obj = new P309_Best_Time_To_Sell_Stock_With_Cooldown();
		System.out.println(obj.maxProfit(new int[] {1,2,3,0,2}));
	}
}
