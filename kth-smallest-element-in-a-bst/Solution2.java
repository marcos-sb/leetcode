class Solution {
    private int kth = -1;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        return inOrder(root, k);
    }

    public int inOrder(TreeNode root, int k) {
        if (root == null) return -1;
        final var left = inOrder(root.left, k);
        if (left != -1) return left;
        if (--kth == 0) return root.val;
        return inOrder(root.right, k);
    }
}
