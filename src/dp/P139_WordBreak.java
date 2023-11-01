package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P139_WordBreak {
	int[] dp = new int[300];
    {
        Arrays.fill(dp, -1);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        wordDict.forEach(e -> dict.add(e));
        return generate(0, s, dict);
    }

	private boolean generate(int index, String s, Set<String> dict) {
		if (index == s.length()) {
			return true;
		}
		if (dp[index] != -1) {
			return dp[index] == 1 ? true : false;
		}
		boolean result = false;
		for(int i = index + 1; i <= s.length(); i++) {
			if (dict.contains(s.substring(index, i))) {
				result |= generate(i, s, dict);
			}
        }
		dp[index] = result ? 1 : 0;
		return result;
	}
	
	public static void main(String[] args) {
		P139_WordBreak obj = new P139_WordBreak();
		System.out.println(obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
	}
}
