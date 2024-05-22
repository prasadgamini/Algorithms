package edu.trees.binary;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 *         3
 *        / \
 *       1   4
 *      /   / \
 *     3   1   5
 * </p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 */
public class GoodNodeCounter {
    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val());
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node != null) {
            //goodNodeValue is 1 if it good, 0 otherwise
            int goodNodeValue = (node.val() >= maxSoFar) ? 1 : 0;
            maxSoFar = Math.max(maxSoFar, node.val());
            return dfs(node.left(), maxSoFar) + dfs(node.right(), maxSoFar) + goodNodeValue;
        }
        return 0;
    }
}
