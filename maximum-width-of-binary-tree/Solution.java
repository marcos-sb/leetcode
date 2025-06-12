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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        final var level = new LinkedList<Pair<TreeNode, Integer>>();
        level.offer(new Pair(root, 0));

        var maxWidth = 0;
        while (!level.isEmpty()) {
            final var size = level.size();
            final var minPos = level.peek().getValue();
            var first = 0;
            var last = 0;
            for (var i = 0; i < size; ++i) {
                final var curr = level.poll();

                final var pos = curr.getValue() - minPos;
                if (i == 0) first = pos;
                if (i == size-1) last = pos;

                final var node = curr.getKey();
                if (node.left != null) {
                    level.offer(new Pair<>(node.left, 2*pos));
                }
                if (node.right != null) {
                    level.offer(new Pair<>(node.right, 2*pos+1));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
