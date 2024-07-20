package arrays;

import java.util.HashMap;
import java.util.Map;

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
		int res = 0, idx = -1;
		Map<Character, Integer> mp = new HashMap<>();
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt( j );
			idx = Math.max( mp.getOrDefault( c, 0 ), idx );
			res = Math.max( res, j - idx + 1 );
			mp.put( c, j + 1 );
		}
		return res;
	}
	
	public static void main(String[] args) {
		var l = new P0003_Longest_Substring_Without_Repeating();
		System.out.println( l.lengthOfLongestSubstring( "abcdef" ) );
		System.out.println( l.lengthOfLongestSubstring( "aacdefoooooooo" ) );
	}
}
