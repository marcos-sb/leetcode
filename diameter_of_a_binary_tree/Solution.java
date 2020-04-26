package diameter_of_a_binary_tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diam(root);
        return diam;
    }
    private int diam(TreeNode node) {
        if (node == null) return -1;
        int left = diam(node.left) + 1;
        int right = diam(node.right) + 1;
        diam = Math.max(diam, left+right);
        return Math.max(left, right);
    }
}
