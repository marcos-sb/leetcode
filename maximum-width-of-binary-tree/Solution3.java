/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxWidth;
    private List<Integer> leftmostPos;

    public Solution() {
        this.maxWidth = 1;
        this.leftmostPos = new ArrayList<>();
    }

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;

        if (depth == leftmostPos.size()) {
            leftmostPos.add(pos);
        } else {
            maxWidth = Math.max(maxWidth, pos - leftmostPos.get(depth) + 1);
        }

        dfs(root.left, depth+1, 2*pos);
        dfs(root.right, depth+1, 2*pos+1);
    }
}
