package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P39_Combination_Sum {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		generate(candidates, target, 0, new LinkedList<Integer>());
		return res;
	}
	private void generate(int[] candidates, int target, int i, Deque<Integer> list) {
		if (target < 0 || i >= candidates.length) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		list.addLast(candidates[i]);
		generate(candidates, target - candidates[i], i, list);
		list.removeLast();
		generate(candidates, target, i + 1, list);
	}
	public static void main(String[] args) {
		var obj = new P39_Combination_Sum();
		System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
	}
}
