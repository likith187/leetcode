package arrays;

import java.util.HashMap;
import java.util.Map;

public class P0395_Longest_Substring_With_Atleast_K {
	public int longestSubstring(String s, int k) {
		int res = 0;
		for (int i = 1; i <= 26; i++) {
			int left = 0;
			Map<Character, Integer> counter = new HashMap<>();
			for(int j = 0; j < s.length(); j++) {
				Character c = s.charAt(j);
				counter.put(c, counter.getOrDefault(c, 0) + 1);
				while (counter.size() > i) {
					char lc = s.charAt(left++);
					counter.put(lc, counter.get(lc) - 1);
					if (counter.get(lc) == 0) {
						counter.remove(lc);
					}
				}
				if (counter.values().stream().allMatch(e -> e >= k) && counter.size() >= i) {
					res = Math.max(res, j - left +1);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		var obj = new P0395_Longest_Substring_With_Atleast_K();
		System.out.println(obj.longestSubstring("aaabb", 3));
	}
}
