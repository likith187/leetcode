package leetcode.string;

import java.util.*;

public class P0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] charCount = new int[26];
            for (char c: str.toCharArray()) {
                charCount[c - 'a']++;
            }
            String key = Arrays.toString(charCount);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsOptimal(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs){
            char[] representation = new char[26];
            for (int i=0; i < str.length(); i++){
                representation[str.charAt(i) -'a']++;
            }
            String curr = String.valueOf(representation);
            if (!map.containsKey(curr)){
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(str);
        }
        for (List<String> item : map.values()){
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        var obj = new P0049_Group_Anagrams();
        System.out.println(obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
