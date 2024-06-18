package arrays;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class P105_Construct_BT_From_Pre_And_In_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return generate(preorder, map, 0, 0, inorder.length - 1);
	}

	private TreeNode generate(int[] preorder, Map<Integer, Integer> map, int i, int j, int k) {
		if (j > k || i >= preorder.length) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[i]);
		int search = map.get(preorder[i]);
		node.left = generate(preorder, map, i + 1, j, search - 1);
		node.right = generate(preorder, map, i + 1 + (search - j), search + 1, k);
		return node;
	}
	
	public static void main(String[] args) {
		var obj = new P105_Construct_BT_From_Pre_And_In_Traversal();
		obj.buildTree(new int[] {1,2,3}, new int[] {2,3,1});
	}
}
