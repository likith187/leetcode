package arrays;

public class P35_Search_Insert_Position {
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
		var obj = new P35_Search_Insert_Position();
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
	}
}
