package edu.lineards.sll;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @org.junit.jupiter.api.Test
    void reverse() {
        var list = createList();
        print(list);
        var revList = ReverseLinkedList.reverse(list);
        print(revList);
        SLLNode ptr = revList;
        for (int i = 10; i > 0; i--) {
            assert ptr.val == i;
            ptr = ptr.next;
        }
    }

    @org.junit.jupiter.api.Test
    void testReverseWithEdgeCases() {
        SLLNode list = null;
        var revList = ReverseLinkedList.reverse(list);
        assertNull(revList);

        list = new SLLNode(10);
        revList = ReverseLinkedList.reverse(list);
        assert revList.val == 10;
        assert revList.next == null;
    }


    private SLLNode createList() {
        SLLNode head = new SLLNode(1);
        SLLNode prev = head;
        for (int i = 2; i <= 10; i++) {
            SLLNode node = new SLLNode(i);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    private void print(SLLNode head) {
        for (SLLNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.println(" -> X");
            }
        }
    }
}