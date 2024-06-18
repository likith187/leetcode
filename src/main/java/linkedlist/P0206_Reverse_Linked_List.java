package linkedlist;

import common.ListNode;

public class P0206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var obj = new P0206_Reverse_Linked_List();
        System.out.println(obj.reverseList(ListNode.of(1,2,3,4,5)));
    }
}
