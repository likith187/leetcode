package leetcode.linkedlist;

public class P0138_Copy_List_With_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node node = head;
        while (node != null) {
            Node temp = new Node(node.val);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        Node curr = head;
        Node clonedHead = head.next;
        Node clonedCurr = clonedHead;
        while (clonedCurr.next != null) {
            curr.next = curr.next.next;
            clonedCurr.next = clonedCurr.next.next;
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }
        curr.next = null;
        return clonedHead;
    }

    public static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
