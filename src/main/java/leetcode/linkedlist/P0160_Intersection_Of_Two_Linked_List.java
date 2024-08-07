package leetcode.linkedlist;

import common.ListNode;

public class P0160_Intersection_Of_Two_Linked_List {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return  null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == b) {
                return a;
            }
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        var obj = new P0160_Intersection_Of_Two_Linked_List();
        ListNode c = new ListNode(3);
        System.out.println(obj.getIntersectionNode(c, new ListNode(2, c)));
    }
}
