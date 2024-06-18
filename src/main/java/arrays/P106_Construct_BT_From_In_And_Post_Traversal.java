package arrays;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class P106_Construct_BT_From_In_And_Post_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return generate(inorder,  postorder, map, inorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode generate(int[] inorder, int[] postorder, Map<Integer, Integer> map, int i, int j, int k) {
		if (j > k || k >= inorder.length) {
			return null;
		}
		if (j == k) {
			return new TreeNode(postorder[i]);
		}
		TreeNode node = new TreeNode(postorder[i]);
		int search = map.get(postorder[i]);
		node.right = generate(inorder, postorder, map, i - 1, search + 1, k);
		node.left = generate(inorder, postorder, map, i - (k - search) - 1, j, search - 1);
		return node;
	}
	
	public static void main(String[] args) {
		var obj = new P106_Construct_BT_From_In_And_Post_Traversal();
		obj.buildTree(new int[] {3,2,1}, new int[] {3,2,1});
	}
}
