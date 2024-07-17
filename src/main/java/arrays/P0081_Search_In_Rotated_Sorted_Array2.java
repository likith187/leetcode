package arrays;

public class P0081_Search_In_Rotated_Sorted_Array2 {
	public boolean search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target || (mid + 1 < nums.length &&  nums[mid + 1] == target)) {
				return true;
			} else if (nums[l] == nums[mid]) {
				l++;
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
		return false;
	}
	public static void main(String[] args) {
		var obj = new P0081_Search_In_Rotated_Sorted_Array2();
		System.out.println(obj.search(new int[] {1,1,1,4}, 4));
	}
}
