package dp;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P95_UniqueBinaryTrees2 {
	
	public static void main(String[] args) {
		P95_UniqueBinaryTrees2 obj = new P95_UniqueBinaryTrees2();
		System.out.println(obj.generateTrees(4).size());
	}
	
	public List<TreeNode> generateTrees(int n) {
		return calculate(0, n, n);
	}

	public List<TreeNode> calculate(int l, int r, int n) {
		if (l >= r) {
			return Collections.singletonList(null);
		}
		List<TreeNode> result = new ArrayList<>();
		for (int i = l; i < r; i++) {
			for (TreeNode left: calculate(l, i, n)) {
				for (TreeNode right: calculate(i + 1, r, n)) {
					result.add(new TreeNode(i, left, right));
				}	
			}
		}
		return result;
	}

}
