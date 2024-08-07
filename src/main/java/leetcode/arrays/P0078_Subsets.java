package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class P0078_Subsets {
	
	List<List<Integer>> result = new ArrayList<>();
	
	public List<List<Integer>> subsets(int[] nums) {
		solve(new ArrayList<>(), nums, 0);
		return result;
	}

	private void solve(List<Integer> list, int[] nums, int i) {
		if (i >= nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		solve(list, nums, i + 1);
		list.add(nums[i]);
		solve(list, nums, i + 1);
		list.remove(nums[i]);
	}
	public static void main(String[] args) {
		System.out.println(new int[] {1,2}.hashCode() +" "+new int[]{1,2}.hashCode());
	}
}
