package arrays;

public class P0122_Best_Time_To_Buy_And_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var obj = new P0122_Best_Time_To_Buy_And_Sell_Stock_II();
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
