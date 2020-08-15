package edu.lrucache;

public class DoubleLinkedList {
    private Node head, tail;

    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (head == null && tail == null) {
            head = tail = null;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    public void removeNode(Node node) {
        if (head == node && tail == node) {
            head = tail = null;
        } else if (head == node) {
            head = head.next;
            head.previous = null;
        } else if (tail == node) {
            tail = tail.previous;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        node.previous = node.next = null;
    }

    public Node removeTailNode() {
        Node tail = this.tail;
        this.removeNode(this.tail);
        return tail;
    }

    public void moveNodeToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}
