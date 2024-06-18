package linkedlist;

import common.TreeNode;

public class P0114_Flatten_Binary_Tree_To_Linked_List {
    public void flatten(TreeNode root) {
        run(root);
    }

    public TreeNode run(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = run(root.left);
        TreeNode temp = root.right;
        if (left != null) {
            root.right = left;
            root.left = null;
            while (left.right != null) left = left.right;
            left.right = temp;
        }
        run(temp);
        return root;
    }

    public static void main(String[] args) {

    }
}
