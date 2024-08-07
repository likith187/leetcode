package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class P152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		Map<String, Integer> dp = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, generate(i, 1, nums, dp));
		}
		return max;
	}

	private int generate(int index, int product, int[] nums, Map<String, Integer> dp) {
		if (index == nums.length) {
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
		dp.put(key, Math.max(product , generate(index + 1, product, nums, dp)));
		return dp.get(key);
	}

	public static void main(String[] args) {
		var v = new P152_Maximum_Product_Subarray();
		System.out.println(v.maxProduct(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
	}
}
