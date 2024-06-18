package arrays;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
//of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
// 
//
//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P0039_Combination_Sum {
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
		var obj = new P0039_Combination_Sum();
		System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
	}
}
