package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P0090_Subsets2 {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		generate(nums, 0, new LinkedList<Integer>());
		return res;
	}

	private void generate(int[] candidates, int i, Deque<Integer> list) {
		if (i >= candidates.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		list.addLast(candidates[i]);
		generate(candidates, i + 1, list);
		list.removeLast();
		int t = i;
		while (t < candidates.length && candidates[t] == candidates[i]) {
			t++;
		}
		generate(candidates, t, list);
	}

	public static void main(String[] args) {
		var obj = new P0090_Subsets2();
		System.out.println(obj.subsetsWithDup(new int[] { 1,2,2}));
	}
}
