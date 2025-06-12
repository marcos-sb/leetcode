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
            var max = Integer.MIN_VALUE;
            var min = Integer.MAX_VALUE;
            for (var i = 0; i < size; ++i) {
                final var curr = level.poll();
                final var pos = curr.getValue() - minPos;
                final var node = curr.getKey();

                max = Math.max(max, pos);
                min = Math.min(min, pos);
                if (node.left != null) {
                    level.offer(new Pair<>(node.left, 2*pos));
                }
                if (node.right != null) {
                    level.offer(new Pair<>(node.right, 2*pos+1));
                }
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }

        return maxWidth;
    }
}
