package linkedlist;

import common.ListNode;

public class P0338_Odd_Even_List {
    public ListNode oddEvenList(ListNode head) {
        int i = 0;
        ListNode curr = head;
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode o = odd, e = even;
        while (curr != null) {
            ListNode temp = curr.next;
            if (i % 2 != 0) {
                e.next = curr;
                e = e.next;
            } else {
                o.next = curr;
                o = o.next;
            }
            curr.next = null;
            curr = temp;
            i++;
        }
        o.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        var obj = new P0338_Odd_Even_List();
        System.out.println(obj.oddEvenList(ListNode.of(4,5,1,9)));
    }
}
