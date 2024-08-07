package leetcode.stack;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0094_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            answer.add(curr.val);
            curr = curr.right;
        }
        return answer;
    }
    public static void main(String[] args) {
        var obj = new P0094_Inorder_Traversal();
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3),null));
        System.out.println(obj.inorderTraversal(node));
    }
}
