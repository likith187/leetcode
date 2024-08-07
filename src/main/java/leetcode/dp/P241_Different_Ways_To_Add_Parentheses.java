package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P241_Different_Ways_To_Add_Parentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		String temp = "";
		List<String> list = new ArrayList<>();
		for (char c:expression.toCharArray()) {
			if (c == '-' || c== '+' || c == '*') {
				list.add(temp);
				temp = "";
				list.add(c + "");
			} else {
				temp = temp + c;
			}
		}
		list.add(temp);
		return generate(0, list.size() - 1, list, new HashMap<>());
	}
	private List<Integer> generate(int i, int j, List<String> list, Map<String, List<Integer>> dp) {
		String key = i + "" + j;
		if (dp.containsKey(key)) {
			dp.get(key);
		}
		if (i == j) {
			dp.put(key, List.of(Integer.valueOf(list.get(i))));
			return dp.get(key);
		}
		List<Integer> results = new ArrayList<>();
		for(int k = i + 1; k < j; k+=2) {
			List<Integer> left = generate(i, k - 1, list, dp);
			List<Integer> right = generate(k + 1, j, list, dp);
			String c = list.get(k);
			for(int l: left) {
				for(int r: right) {
					if (c.equals("+")) {
						results.add(l + r);
					} else if (c.equals("-")) {
						results.add(l - r);
					} else if (c.equals("*")) {
						results.add(l * r);
					}
				}
			}
		}
		return results;
	}
	public static void main(String[] args) {
		var obj = new P241_Different_Ways_To_Add_Parentheses();
		System.out.println(obj.diffWaysToCompute("2-1-1"));
	}
}
