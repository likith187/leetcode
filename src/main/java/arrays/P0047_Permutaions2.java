package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P0047_Permutaions2 {

	List<List<Integer>> answers = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		generate(nums, 0);
		return answers;
	}

	private void generate(int[] nums, int start) {
		if (start == nums.length) {
			answers.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				swap(nums, start, i);
				generate(nums, start + 1);
				swap(nums, start, i);
				set.add(nums[i]);
			}
		}
	}

	private void swap(int[] nums, int start, int i) {
		int t = nums[i];
		nums[i] = nums[start];
		nums[start] = t;
	}

	public static void main(String[] args) {
		var obj = new P0047_Permutaions2();
		System.out.println(obj.permuteUnique(new int[]{1,1,3}));
	}
}
