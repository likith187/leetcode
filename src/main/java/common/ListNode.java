package common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(Integer... ints) {
        if (ints.length == 0) return null;
        ListNode list = new ListNode(ints[0]);
        ListNode curr = list;
        for(int i = 1; i < ints.length; i++) {
            curr.next = new ListNode(ints[i]);
            curr = curr.next;
        }
        return list;
    }

    public List<Integer> list() {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        ListNode temp = next;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}