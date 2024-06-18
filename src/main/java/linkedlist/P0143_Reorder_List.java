package linkedlist;

import common.ListNode;

public class P0143_Reorder_List {

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode dummy = new ListNode();
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = temp;
        }
        ListNode curr = head;
        slow = dummy.next;
        while (slow != null && curr != null) {
            ListNode temp = slow.next;
            slow.next = curr.next;
            curr.next = slow;
            prev = slow;
            curr = slow.next;
            slow = temp;
        }
        if (slow != null) {
            prev.next = slow;
        }
    }

    public static void main(String[] args) {
        var obj = new P0143_Reorder_List();
        obj.reorderList(ListNode.of(1));
    }
}
