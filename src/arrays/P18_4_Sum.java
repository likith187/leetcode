package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4_Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(0, 4, target, nums);
	}

	private List<List<Integer>> kSum(int i, int k, long target, int[] nums) {
		if (k == 2) {
			return twoSum(i, target, nums);
		}
		List<List<Integer>> answers = new ArrayList<>();
		for (int j = i; j < nums.length; j++) {
			if (j == i || nums[j - 1] != nums[j]) {
				for (List<Integer> ans : kSum(j + 1, k - 1, target - nums[j], nums)) {
					ans.add(0, nums[j]);
					answers.add(ans);
				}
			}
		}
		return answers;
	}

	private List<List<Integer>> twoSum(int start, long target, int[] nums) {
		List<List<Integer>> answers = new ArrayList<>();
		int lo = start, hi = nums.length - 1;
		while (lo < hi) {
			int currSum = nums[lo] + nums[hi];
			if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
				++lo;
			} else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
				--hi;
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[lo++]);
				temp.add(nums[hi--]);
				answers.add(temp);
			}
		}
		return answers;
	}

	public static void main(String[] args) {
		var obj = new P18_4_Sum();
		System.out.println(obj.fourSum(new int[] { 2, 2, 2, 2 }, 8));
	}
}
