package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
// 
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
//
// 
//
//Constraints:
//
//    3 <= nums.length <= 3000
//    -105 <= nums[i] <= 105

public class P0015_3_Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort( nums );
		return kSum( 0, 3, 0, nums );
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
		var obj = new P0015_3_Sum();
		System.out.println( obj.threeSum( new int[] {-1,0,1,2,-1,-4} ) );
	}
}
