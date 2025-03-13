class Solution {
    private int smallestVisited = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        final var left = kthSmallest(root.left, k);
        if (left != -1) return left;
        if (++smallestVisited == k) return root.val;
        return kthSmallest(root.right, k);
    }
}
