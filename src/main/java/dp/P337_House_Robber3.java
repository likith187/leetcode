package dp;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P337_House_Robber3 {
	public int rob(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		return Math.max(generate(root, map, true), generate(root, map, false));
	}
	
	public int generate(TreeNode root, Map<String, Integer> map, boolean rob) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			if (rob) {
				return root.val;
			} else {
				return 0;
			}
		}
		String key = root.toString() + rob;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int res;
		if (rob) {
			res = Math.max(root.val + generate(root.left, map, !rob) + generate(root.right, map, !rob), generate(root.left, map, rob) + generate(root.right, map, rob));
		} else {
			res = generate(root.left, map, !rob) + generate(root.right, map, !rob);
		}
		map.put(key, res);
		return res;
	}

}
