package leetcode.linkedlist;

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Input: head = [1,1,1,2,3]
//Output: [2,3]

import common.ListNode;

public class P0082_Remove_Duplicates_From_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head, prev = dummy;
        boolean flag = false;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr = curr.next;
                prev.next = curr.next;
                flag = true;
            }
            else {
                if (flag) {
                    flag = false;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var obj = new P0082_Remove_Duplicates_From_Sorted_List_II();
        System.out.println(obj.deleteDuplicates(ListNode.of(99,1,1,1,2,2,2,3,3,3,3,5)).list());
    }
}
