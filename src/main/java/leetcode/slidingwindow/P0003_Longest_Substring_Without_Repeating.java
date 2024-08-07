package leetcode.slidingwindow;

//3. Longest Substring Without Repeating Characters
//Solved
//Medium
//Topics
//Companies
//Hint
//
//Given a string s, find the length of the longest
//substring
//without repeating characters.
//
// 
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


public class P0003_Longest_Substring_Without_Repeating {
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int[] arr = new int[256];
		int t = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			t = Math.max(t, arr[c]);
			max = Math.max(max, i - t + 1);
			arr[c] = i + 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		var l = new P0003_Longest_Substring_Without_Repeating();
		System.out.println( l.lengthOfLongestSubstring( "abcdef" ) );
		System.out.println( l.lengthOfLongestSubstring( "aacdefoooooooo" ) );
	}
}
