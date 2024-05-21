package edu.lineards.sll;


public class SLLNode {
    int val;
    SLLNode next;

    public SLLNode(int val) {
        this.val = val;
    }

    public SLLNode(int val, SLLNode next) {
        this.val = val;
        this.next = next;
    }
}
