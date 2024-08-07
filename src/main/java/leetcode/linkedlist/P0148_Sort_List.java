package leetcode.linkedlist;

import common.ListNode;

public class P0148_Sort_List {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 == null || list1 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 == null) {
            temp.next = temp2;
        }
        else {
            temp.next = temp1;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode firstHalf = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return mergeTwoLists(firstHalf, secondHalf);
    }
}
