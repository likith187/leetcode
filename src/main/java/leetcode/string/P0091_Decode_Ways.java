package leetcode.string;

import java.util.Arrays;

public class P0091_Decode_Ways {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return calculate(s, dp, 0);
    }

    private int calculate(String s, int[] dp, int i) {
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
        if (s.charAt(i) != '0') {
            res = calculate(s, dp, i + 1);
            if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                res += calculate(s, dp, i + 2);
            }
        }
        dp[i] = res;
        return res;
    }

    public static void main(String[] args) {
        var obj = new P0091_Decode_Ways();
        System.out.println(obj.numDecodings("2611055971756562"));
    }
}
