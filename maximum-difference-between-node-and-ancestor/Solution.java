class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return aux(root, root.val, root.val);
    }
    private static int aux(TreeNode root, int max, int min) {
        if (root == null) return 0;
        final var _max = Math.max(max, root.val);
        final var _min = Math.min(min, root.val);
        final var maxDiff = Math.max(Math.abs(_max - root.val), Math.abs(_min - root.val));
        final var maxDiffLeft = aux(root.left, _max, _min);
        final var maxDiffRight = aux(root.right, _max, _min);
        return Math.max(Math.max(maxDiff, maxDiffLeft), maxDiffRight);
    }
}
