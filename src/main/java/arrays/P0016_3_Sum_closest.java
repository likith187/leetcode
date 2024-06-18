package arrays;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
// 
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
// 
//
//Constraints:
//
//    3 <= nums.length <= 500
//    -1000 <= nums[i] <= 1000
//    -104 <= target <= 104



import java.util.Arrays;

public class P0016_3_Sum_closest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int answer = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int start = i + 1;
			int lo = start, hi = nums.length - 1;
		    
	        while (lo < hi) {
	            int currSum = nums[i] + nums[lo] + nums[hi];
	            if (Math.abs(currSum - target) < min) {
	            	min = Math.abs(currSum - target);
	            	answer = currSum;
	            }
	            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
	                ++lo;
	            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
	                --hi;
	            } else {
	            	answer = target;
	            	break;
	            }
	        }
		}
		return answer;
	}
	
	public static void main(String[] args) {
		var obj = new P0016_3_Sum_closest();
		System.out.println(obj.threeSumClosest(new int[] {0,0,0}, 1));
	}

}
