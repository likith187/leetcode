package leetcode.arrays;

import java.util.*;

public class P0140_Word_Break_II {
    Stack<String> stack = new Stack<>();
    private Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return List.of(String.join(" ", stack));
        }
        String hash = s + stack.hashCode();
        if (cache.containsKey(hash)) {
            return cache.get(hash);
        }
        List<String> result = new ArrayList<>();
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                stack.push(word);
                result.addAll(wordBreak(s.substring(word.length()), wordDict));
                stack.pop();
            }
        }
        cache.put(hash, result);
        return result;
    }

    public static void main(String[] args) {
        var obj = new P0140_Word_Break_II();
        var result = obj.wordBreak("aaaaaaa", List.of("aaaa","aaa"));
        System.out.println(result);
    }
}
