package takeuforward.arrays.medium;

public class P06_Stock_Buy_And_Sell {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min < prices[i]) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var obj = new P06_Stock_Buy_And_Sell();
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
