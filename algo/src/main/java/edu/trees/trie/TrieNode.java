package edu.trees.trie;

import java.util.Arrays;

public class TrieNode {
    private char val;
    private TrieNode[] nextNodes;
    private boolean isLeaf;

    public TrieNode() {
        this('\0'); // root
    }

    public TrieNode(char val) {
        this(val, false);
    }

    public TrieNode(char val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.nextNodes = new TrieNode[26];
    }

    public TrieNode getNext(char ch) {
        return this.nextNodes[ch - 'a'];
    }

    public void addNext(char ch) {
        if (this.nextNodes[ch - 'a'] == null) {
            this.nextNodes[ch - 'a'] = new TrieNode(ch);
        }
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String toString() {
        return "{" +
                "val=" + val +
                ", nextNodes=" + Arrays.toString(nextNodes) +
                ", isLeaf=" + isLeaf +
                '}';
    }
}
