package linkedlist;

//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//Input: head = [1,1,2]
//Output: [1,2]
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]

import common.ListNode;

public class P0083_Remove_Duplicates_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode();
        ListNode curr = head, prev = dump;
        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return dump.next;
    }

    public static void main(String[] args) {
        var obj = new P0083_Remove_Duplicates_From_Sorted_List();
        System.out.println(obj.deleteDuplicates(ListNode.of(1,1,2,3,3,4,4,4,4,4,4)).list());
    }
}
