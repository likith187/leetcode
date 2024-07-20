package takeuforward.arrays.medium;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
// 
//
//Constraints:
//
//    2 <= nums.length <= 104
//    -109 <= nums[i] <= 109
//    -109 <= target <= 109
//    Only one valid answer exists.

public class P01_Two_Sum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> mp = new HashMap<>();
		for ( int i = 0; i < nums.length; i++ ) {
			mp.put( nums[i], i );
		}
		for ( int i = 0; i < nums.length; i++ ) {
			Integer result = mp.get( target - nums[i] );
			if ( result != null && i != result ) {
				return new int[]{ i, result };
			}
		}
		return new int[]{ 0, 0 };
	}
}

//public class P1_Two_Sum {
//
//	public int[] twoSum(int[] nums, int target) {
//		Map<Integer, Integer> map = new HashMap<>( nums.length );
//		for ( int i = 0; i < nums.length; i++ ) {
//			int complement = target - nums[i];
//			if ( map.containsKey( complement ) ) {
//				return new int[]{ i, map.get( complement ) };
//			}
//			map.put( nums[i], i );
//		}
//		return null;
//	}
//}
