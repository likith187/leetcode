package leetcode.dp;

import java.util.Arrays;

public class P322_Coin_Change {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, 999999);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
			}
		}
		return dp[amount] != 999999 ? dp[amount] : -1;
	}
	
	public static void main(String[] args) {
		var obj = new P322_Coin_Change();
		System.out.println(obj.coinChange(new int[]{2}, 3));
	}
}
