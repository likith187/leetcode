package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P47_Permutaions2 {

	List<List<Integer>> answers = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		generate(nums, 0, nums.length);
		return answers;
	}

	private void generate(int[] nums, int start, int end) {
		if (start == end) {
			answers.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		for (int i = start; i < end; i++) {
			swap(nums, start, i);
			generate(nums, start + 1, end);
			swap(nums, start, i);
		}
	}

	private void swap(int[] nums, int start, int i) {
		int t = nums[i];
		nums[i] = nums[start];
		nums[start] = t;
	}

	public static void main(String[] args) {
		var obj = new P46_Permutations_Optimized();
		System.out.println(obj.permute(new int[]{1,1,3}));
	}
}
