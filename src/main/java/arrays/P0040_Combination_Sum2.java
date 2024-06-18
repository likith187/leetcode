package arrays;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
// 
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
//
// 
//
//Constraints:
//
//    1 <= candidates.length <= 100
//    1 <= candidates[i] <= 50
//    1 <= target <= 30



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P0040_Combination_Sum2 {
	
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
		var obj = new P0040_Combination_Sum2();
		System.out.println(obj.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
	}

}
