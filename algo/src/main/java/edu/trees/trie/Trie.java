package edu.trees.trie;


/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode node = this.root;
        for (char ch : charArray) {
            node.addNext(ch);
            node = node.getNext(ch);
        }
        node.setLeaf(true);
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode node = this.root;
        for (char ch : charArray) {
            TrieNode nextNode = node.getNext(ch);
            if (nextNode == null) {
                return false;
            }
            node = nextNode;
        }
        return node.isLeaf();
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode node = this.root;
        for (char ch : charArray) {
            TrieNode nextNode = node.getNext(ch);
            if (nextNode == null) {
                return false;
            }
            node = nextNode;
        }
        return true;
    }
}
