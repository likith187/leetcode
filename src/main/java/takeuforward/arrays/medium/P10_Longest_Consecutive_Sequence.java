package takeuforward.arrays.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P10_Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
		int result = 0;
		Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
		Set<Integer> seen = new HashSet<>();
		for(int i: nums) {
			if (!seen.contains(i)) {
				Stack<Integer> stack = new Stack<>();
				stack.push(i);
				int max = 0;
				while (!stack.isEmpty()) {
					int num = stack.pop();
					seen.add(num);
					max++;
					if(set.contains(num - 1) && !seen.contains(num - 1)) {
						stack.push(num - 1);
					}
					if (set.contains(num + 1) && !seen.contains(num + 1)) {
						stack.push(num + 1);
					}
				}
				result = Math.max(result, max);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		var obj = new P10_Longest_Consecutive_Sequence();
		System.out.println(obj.longestConsecutive(new int[] {100,4,200,1,3,2}));
	}
}
