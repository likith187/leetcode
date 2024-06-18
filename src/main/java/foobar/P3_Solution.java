package foobar;

import java.util.HashMap;
import java.util.Map;

public class P3_Solution {
	public static String solution(int[] nums) {
		
		Map<String, Integer> dp = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
//			System.out.println(generate(i, 1, nums, dp));
			max = Math.max(max, generate(i, 1, nums, dp));
		}
		return String.valueOf(max);
    }

	private static int generate(int index, int product, int[] nums, Map<String, Integer> dp) {
		if (index >= nums.length) {
			return product;
		}
		if (nums[index] == 0) {
			return 0;
		}
		String key = index + "_" + product;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		product = product * nums[index];
		int res = Math.max(product , generate(index + 1, product, nums, dp));
		res = Math.max(res , generate(index + 2, product, nums, dp));
		dp.put(key, res);
		return dp.get(key);
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {-1}));
	}
}
