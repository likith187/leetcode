package arrays;

import java.util.Arrays;

public class P0075_Sort_Colors {
	public void sortColors(int[] nums) {
		int l = 0, r = nums.length - 1, i = 0;
		while (i <= r) {
			if (nums[i] == 2) {
				nums[i] = nums[r];
				nums[r--] = 2;
			} else if (nums[i] == 0){
				nums[i] = nums[l];
				nums[l++] = 0; 
				i++;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		var obj = new P0075_Sort_Colors();
		int[] arr = { 2, 0,1,2, 2, 2, 0, 2, 1, 1, 0 };
		obj.sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
}
