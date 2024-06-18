package linkedlist;

import common.ListNode;

public class P0237_Delete_Node_In_A_Linked_List {
    public void deleteNode(ListNode node) {
        int val = node.val;
        ListNode pprev = node;
        ListNode prev = node;
        ListNode curr = node.next;
        while (curr != null) {
            if (curr.val != val) {
                prev.val = curr.val;
                pprev = prev;
                prev = prev.next;
            }
            curr = curr.next;
        }
        pprev.next = null;
    }

    public static void main(String[] args) {
        var obj = new P0237_Delete_Node_In_A_Linked_List();
        ListNode list = ListNode.of(4,5,1,9);
        obj.deleteNode(list.next);
        System.out.println(list);
    }
}
