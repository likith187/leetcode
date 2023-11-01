package arrays;

import java.util.Arrays;

public class P16_3_Sum_closest {
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
		var obj = new P16_3_Sum_closest();
		System.out.println(obj.threeSumClosest(new int[] {0,0,0}, 1));
	}

}
