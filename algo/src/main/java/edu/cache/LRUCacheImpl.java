package edu.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl implements Cache {
    int size, capacity;
    DoubleLinkedList doubleLinkedList;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        doubleLinkedList = new DoubleLinkedList();
    }

    @Override
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            doubleLinkedList.moveNodeToHead(node);
        } else if (map.size() < capacity) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            doubleLinkedList.addNode(newNode);
        } else {
            Node tailNode = doubleLinkedList.removeTailNode();
            map.remove(tailNode.key);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            doubleLinkedList.addNode(newNode);
        }
    }

    @Override
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            doubleLinkedList.moveNodeToHead(node);
            return node.value;
        }
        return -1;
    }
}
