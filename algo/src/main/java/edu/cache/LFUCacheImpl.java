package edu.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCacheImpl implements Cache {
    private PriorityQueue<LFUNode> minHeap;
    private Map<Integer, LFUNode> map;
    private int cap;

    public LFUCacheImpl(int cap) {
        this.minHeap = new PriorityQueue<>();
        this.map = new HashMap<>();
        this.cap = cap;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            LFUNode node = map.get(key);
            node.value = value;
            minHeap.remove(node);
            node.incrementWeight();
            minHeap.add(node);
        } else if(map.size() < cap) {
            LFUNode node = new LFUNode(key, value);
            map.put(key, node);
            minHeap.add(node);
        } else {
            LFUNode removingNode = minHeap.remove();
            map.remove(removingNode.key);

            LFUNode newNode = new LFUNode(key, value);
            map.put(key, newNode);
            minHeap.add(newNode);
        }
    }


    public int get(int key) {
        if(map.containsKey(key)) {
            LFUNode node = map.get(key);
            minHeap.remove(node);
            node.incrementWeight();
            minHeap.add(node);
            return node.value;
        }
        return -1;
    }
}
