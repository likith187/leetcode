package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P40_Combination_Sum2 {
	
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		System.out.println(Arrays.toString(candidates));
		generate(candidates, target, 0, new LinkedList<Integer>());
		return res;
	}
	private void generate(int[] candidates, int target, int i, Deque<Integer> list) {
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (target < 0 || i >= candidates.length) {
			return;
		}
		list.addLast(candidates[i]);
		generate(candidates, target - candidates[i], i + 1, list);
		list.removeLast();
		int t = i;
		while (t < candidates.length && candidates[t] == candidates[i]) {
			t++;
		}
		generate(candidates, target, t, list);
	}
	public static void main(String[] args) {
		var obj = new P40_Combination_Sum2();
		System.out.println(obj.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
	}

}
