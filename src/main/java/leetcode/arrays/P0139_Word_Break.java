package leetcode.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0139_Word_Break {
    private Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        boolean result = false;
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                result |= wordBreak(s.substring(word.length()), wordDict);
            }
        }
        System.out.println(s);
        cache.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        var obj = new P0139_Word_Break();
        var result = obj.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a","aa","aaa","aaaa",
                "aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(result);
    }
}
