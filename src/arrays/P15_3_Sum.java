package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3_Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> answers = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			int start = i + 1, target = -nums[i];
			int lo = start, hi = nums.length - 1;
		    
	        while (lo < hi) {
	            int currSum = nums[lo] + nums[hi];
	            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
	                ++lo;
	            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
	                --hi;
	            } else {
	            	answers.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
	            }
	        }
		}
		return answers;
	}
	
	public static void main(String[] args) {
		var obj = new P15_3_Sum();
		System.out.println(obj.threeSum(new int[] {0,0,0,0}));
	}
}
