package leetcode.linkedlist;

import common.ListNode;

import java.util.List;
import java.util.Random;

public class P0382_Linked_List_Random_Node {

    Random random;
    Integer max;
    ListNode head;

    public P0382_Linked_List_Random_Node(ListNode head) {
        this.random = new Random();
        this.head = head;
        int i = 0;
        ListNode curr = head;
        while(curr != null) {
            i++;
            curr = curr.next;
        }
        this.max = i;
    }

    public int getRandom() {
        ListNode curr = head;
        for(int i = 0; i < random.nextInt( max); i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public static void main(String[] args) {
        var obj = new Random();
    }
}
