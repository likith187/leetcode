package leetcode.dp;

public class P32_LongestValidParantheses {
    public int longestValidParentheses(String s) {
    	int n = s.length();
        boolean[] dpCheck = new boolean[n];
        int[] dp = new int[n];
        for(int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
            	dpCheck[i] = true;
            	dpCheck[i + 1] = true;
            }
        }
        return dp[n];
    }
}
