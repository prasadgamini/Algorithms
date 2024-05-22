package edu.trees.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodNodeCounterTest {
    @Test
    void testGoodNodeCounterOne() {
        // Construct the tree [3, 1, 4, 3, null, 1, 5]
        /*
         * ........3
         * ......./ \
         * ......1   4
         * ...../   / \
         * ....3   1   5
         */
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3, null, null),
                        null
                ),
                new TreeNode(4,
                        new TreeNode(1, null, null),
                        new TreeNode(5, null, null)
                )
        );
        assertEquals(4, GoodNodeCounter.goodNodes(root));
    }

    @Test
    void testGoodNodeCounterTwo() {
        /*
                    3
                   /
                  3
                 / \
                4   2
         */
        TreeNode root = new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4, null, null),
                        new TreeNode(2, null, null)
                ),
                null
        );
        assertEquals(3, GoodNodeCounter.goodNodes(root));
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