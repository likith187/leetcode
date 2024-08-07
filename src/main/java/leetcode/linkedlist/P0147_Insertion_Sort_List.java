package leetcode.linkedlist;

import common.ListNode;

public class P0147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = dummy, next = curr.next;
            while (temp.next != null && temp.next.val < curr.val) {
                temp = temp.next;
            }
            curr.next = temp.next;
            temp.next = curr;
            curr = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var obj = new P0147_Insertion_Sort_List();
        System.out.println(obj.insertionSortList(ListNode.of(3, 5, 1, 2, 9, 4, 5, 2)).list());
    }
}

//class Solution {
//    public ListNode insertionSortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode prev = head;
//        ListNode unsortedNode = head.next;
//        while (unsortedNode != null) {
//            ListNode sortprev = null;
//
//            ListNode next = unsortedNode.next;
//            if (unsortedNode.val < prev.val) {
//                for (ListNode temp = head; temp != null && temp != unsortedNode; temp = temp.next) {
//                    if (temp.val > unsortedNode.val) {
//                        unsortedNode.next = temp;
//                        if (sortprev != null) {
//                            sortprev.next = unsortedNode;
//                        }
//                        prev.next = next;
//                        if (unsortedNode.val < head.val) {
//                            head = unsortedNode;
//                        }
//                        break;
//                    }
//                    sortprev = temp;
//                }
//            } else {
//                prev = unsortedNode;
//            }
//            unsortedNode = next;
//
//        }
//        return head;
//    }
//}