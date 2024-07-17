package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str: strs) {
			char[] splits = str.toCharArray();
			Arrays.sort(splits);
			String key = new String(splits);
			map.computeIfAbsent(key, (e) -> new ArrayList<>()).add(str);
		}
		return new ArrayList<>(map.values());
	}
	public static void main(String[] args) {
		var obj = new P0049_Group_Anagrams();
		System.out.println(obj.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(Arrays.hashCode(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(Arrays.hashCode(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}
}
