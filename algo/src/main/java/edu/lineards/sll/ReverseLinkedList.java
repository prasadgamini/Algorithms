package edu.lineards.sll;

public class ReverseLinkedList {
    public static SLLNode reverse(SLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLLNode ptr = head.next;
        SLLNode curr = head;
        head.next = null;
        while (ptr != null) {
            SLLNode temp = ptr.next;
            ptr.next = curr;
            curr = ptr;
            ptr = temp;
        }
        return curr;
    }
}
