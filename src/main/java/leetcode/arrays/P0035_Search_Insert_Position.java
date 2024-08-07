package leetcode.arrays;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//
//Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//
//Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4
//
// 
//
//Constraints:
//
//    1 <= nums.length <= 104
//    -104 <= nums[i] <= 104
//    nums contains distinct values sorted in ascending order.
//    -104 <= target <= 104
//


public class P0035_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		int ans = -1;
		while (l <= r) {
			int mid = (l + r + 1) / 2;
			ans = mid;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		if (target > nums[ans]) {
			return ans + 1;
		} else {
			return ans;
		}
	}

	public static void main(String[] args) {
		var obj = new P0035_Search_Insert_Position();
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
	}
}
