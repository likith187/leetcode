package arrays;

public class P33_Search_In_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (mid + 1 < nums.length &&  nums[mid + 1] == target) {
				return mid + 1;
			} else if(nums[mid] > nums[l]) {
				if (target >= nums[l] && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (target < nums[l] && target > nums[mid]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		var obj = new P33_Search_In_Rotated_Sorted_Array();
		System.out.println(obj.search(new int[] {4,0,1,2,3}, 2));
	}
}
