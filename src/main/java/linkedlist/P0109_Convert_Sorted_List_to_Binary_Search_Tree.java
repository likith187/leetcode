package linkedlist;

import common.ListNode;
import common.TreeNode;

public class P0109_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        return new TreeBuilder(head).dfs(n);
    }



    public static void main(String[] args) {

    }

    public static class TreeBuilder {
        private ListNode head;

        public TreeBuilder(ListNode head) {
            this.head = head;
        }

        public TreeNode dfs(int n) {
            if (n <= 0) {
                return null;
            }
            TreeNode left = dfs(n / 2);
            TreeNode root = new TreeNode(head.val);
            root.left = left;
            head = head.next;
            root.right = dfs(n - n / 2 - 1);
            return root;
        }
    }
}
