package arrays;

import java.util.Arrays;

public class P31_Next_Permutation {
	public void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}
		int max = -1, best = 0, start = 0;
		while (start  < nums.length) {
			int i = nums.length - 1;
			while(i >= 0 && start < i) {
				if (nums[start] < nums[i] && start >= max) {
					max = start;
					best = i;
					break;
				}
				i--;
			}
			start++;
		}
		if (max != -1) {
			int temp = nums[best];
			nums[best] = nums[max];
			nums[max] = temp;
		}
		Arrays.sort(nums, max + 1, nums.length);
	}
	
	public static void main(String[] args) {
		var obj = new P31_Next_Permutation();
		int[] arr = {3,2,1};
		obj.nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
}
