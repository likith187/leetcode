package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answers = new ArrayList<>();
		answers.add(new LinkedList<>());
		for(int i = 1; i <= nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> answer: answers) {
				int size = answer.size();
				for(int j = 0; j < size + 1; j++) {
					answer.add(j, nums[i - 1]);
					temp.add(new LinkedList<>(answer));
					answer.remove(j);
				}
			}
			answers = temp;
		}
		return answers;
	}
	public static void main(String[] args) {
		var obj = new P46_Permutations();
		System.out.println(obj.permute(new int[]{1,2,3}));
	}
}
