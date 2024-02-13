package edu.lrucache;

public class Node {
    Node previous;
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
