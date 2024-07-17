package arrays;

import java.util.Arrays;

public class P0080_Remove_Duplicates_From_Sorted_Array2 {

	public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
		int i = 2, l = 0;
		while (i < nums.length) {
			if (nums[l] != nums[i]) {
				l++;
				nums[l + 1] = nums[i];
			}
			i++;
		}
		return l + 2;
	}

	public static void main(String[] args) {
		var obj = new P0080_Remove_Duplicates_From_Sorted_Array2();
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, obj.removeDuplicates(nums))));
	}
}
