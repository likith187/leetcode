package arrays;

//5. Longest Palindromic Substring
//Solved
//Medium
//Topics
//Companies
//Hint
//
//Given a string s, return the longest
//palindromic
//substring
//in s.
//
// 
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
// 
//
//Constraints:
//
//    1 <= s.length <= 1000
//    s consist of only digits and English letters.



public class P0005_Longest_Palindrome_Substring {
	
	public String longestPalindrome(String s) {
		int start = 0;
        int end = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int len = Math.max(check(s, i, i), check(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
	}
	
	private int check(String s, int l, int r) {
		while (l >=0 && r <= s.length() - 1 && s.charAt( l ) == s.charAt( r )) {
			l--;
			r++;
		}
		return r - l - 1;
	}
	
	public static void main(String[] args) {
		var obj = new P0005_Longest_Palindrome_Substring();
		System.out.println( obj.longestPalindrome( "cbbd" ) );
	}

}
