package edu.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodNodeCounterTest {
    @Test
    void testGoodNodeCounter() {
        TreeNode root = createTree();
        assertEquals(4, GoodNodeCounter.goodNodes(root));
    }


    /**
     * ........3
     * ......./ \
     * ......1   4
     * ...../   / \
     * ....3   1   5
     */
    private TreeNode createTree() {
        TreeNode leftLeaf3 = new TreeNode(3, null, null);
        TreeNode leftMid1 = new TreeNode(1, leftLeaf3, null);
        TreeNode leftLeaf1 = new TreeNode(1, null, null);
        TreeNode rightLeaf5 = new TreeNode(5, null, null);
        TreeNode rightMid4 = new TreeNode(4, leftLeaf1, rightLeaf5);
        return new TreeNode(3, leftMid1, rightMid4);
    }
}