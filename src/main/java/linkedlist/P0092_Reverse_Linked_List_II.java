package linkedlist;

//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//Example 1:
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]

import common.ListNode;

public class P0092_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int diff = right - left;
        ListNode curr = head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (left > 1 ) {
            prev = curr;
            curr = curr.next;
            left--;
        }
        ListNode oldCurr = curr;
        prev.next = null;
        while(diff >= 0) {
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = temp;
            diff--;
        }
        if (oldCurr != null) {
            oldCurr.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var obj = new P0092_Reverse_Linked_List_II();
        System.out.println(obj.reverseBetween(ListNode.of(1,2,3,4,5,6), 1, 1));
    }
}
