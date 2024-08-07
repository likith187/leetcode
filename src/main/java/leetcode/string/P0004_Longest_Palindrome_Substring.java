package leetcode.string;

public class P0004_Longest_Palindrome_Substring {
    public String longestPalindrome(String s) {
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(check(s, i, i), check(s, i, i + 1));
            if (len > ans[1] - ans[0]) {
                // System.out.println(max+ " "+i);
                ans[0] = i - (len - 1) / 2 ;
                ans[1] = i + len / 2;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private int check(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        var obj = new P0004_Longest_Palindrome_Substring();
        System.out.println(obj.longestPalindrome("babad"));
    }
}
