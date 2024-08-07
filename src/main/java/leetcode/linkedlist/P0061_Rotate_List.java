package leetcode.linkedlist;

//Given the head of a linked list, rotate the list to the right by k places.
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]


import common.ListNode;

public class P0061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while( temp.next != null) {
            temp = temp.next;
            count++;
        }
        k = k % count;
        k = count - k;
        ListNode curr = head;
        while( k > 0) {
            temp.next = curr;
            temp = curr;
            curr = curr.next;
            temp.next = null;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
        var obj = new P0061_Rotate_List();
        ListNode listNode = ListNode.of(1,2,3,4,5);
        System.out.println(obj.rotateRight(listNode, 2).list());
    }
}
