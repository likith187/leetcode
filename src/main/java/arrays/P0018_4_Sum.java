package arrays;

//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//    0 <= a, b, c, d < n
//    a, b, c, and d are distinct.
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//
//You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
//
// 
//
//Constraints:
//
//    1 <= nums.length <= 200
//    -109 <= nums[i] <= 109
//    -109 <= target <= 109



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0018_4_Sum {
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
		var obj = new P0018_4_Sum();
		System.out.println(obj.fourSum(new int[] { 2, 2, 2, 2 }, 8));
	}
}
