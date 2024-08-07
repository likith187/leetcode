package leetcode.dp;

public class P121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int low = prices[0];
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
			} else {
				res = Math.max(res, prices[i] - low);
			}
		}
		return res;
	}
}
