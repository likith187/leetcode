package arrays;

import java.util.Arrays;

public class P26_Remove_Duplicates_From_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		int curr = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] != nums[i]) {
				nums[++curr] = nums[i];
			}
		}
		return curr;
	}
	public static void main(String[] args) {
		var obj = new P26_Remove_Duplicates_From_Sorted_Array();
		System.out.println(obj.removeDuplicates(new int[] {0,0,0,0,1,1,1,1,2}));
	}
}
