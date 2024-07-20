package takeuforward.binarysearch.array1D;

//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]
//
// 
//
//Constraints:
//
//    0 <= nums.length <= 105
//    -109 <= nums[i] <= 109
//    nums is a non-decreasing array.
//    -109 <= target <= 109



import java.util.Arrays;

public class P06_First_And_Last_Position {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] result = {-1,-1};
        while (l <= r) {
        	int mid = (l + r) / 2;
        	if (target == nums[mid]) {
        		result[0] = mid;
        		r = mid - 1;
        	}
        	else if (target < nums[mid]) {
        		r = mid - 1;
        	} else {
        		l = mid + 1;
        	}
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
        	int mid = (l + r) / 2;
        	if (target == nums[mid]) {
        		result[1] = mid;
        		l = mid + 1;
        	}
        	else if (nums[mid] < target) {
        		l = mid + 1;
        	} else {
        		r = mid - 1;
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		var obj = new P06_First_And_Last_Position();
		System.out.println(Arrays.toString(obj.searchRange(new int[]{1,8,8,8,8,8,8,8,8,8,10,10}, 1)));
	}
}
