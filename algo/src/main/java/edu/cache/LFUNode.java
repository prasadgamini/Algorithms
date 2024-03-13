package edu.cache;

public class LFUNode implements Comparable<LFUNode> {
    int key;
    int value;
    int weight;

    LFUNode(int key, int val) {
        this.key = key;
        this.value = val;
        this.weight = 1;
    }

    public void incrementWeight() {
        this.weight++;
    }


    public int compareTo(LFUNode other) {
        return Integer.compare(this.weight, other.weight);  // ascending order of weights
    }
}