package linkedlist;

import common.ListNode;

public class P0234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = temp;
        }
        return compare(dummy.next, slow) || compare(dummy.next, slow.next);
    }

    private static boolean compare(ListNode curr, ListNode slow) {
        if (slow == null || curr == null) {
            return false;
        }
        while(slow != null) {
            if (slow.val != curr.val) {
                return false;
            }
            slow = slow.next;
            curr = curr.next;
        }
        return curr == null;
    }

    public static void main(String[] args) {
        var obj = new P0234_Palindrome_Linked_List();
        System.out.println(obj.isPalindrome(ListNode.of(1,1,2,1)));
    }
}
