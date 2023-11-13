class Solution {
    public int rob(TreeNode root) {
        final var res = bt(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] bt(TreeNode root) { // 2^log2(N) => N
        if (root == null) return new int[]{0, 0};
        final var left = bt(root.left);
        final var right = bt(root.right);
        final var robRoot = root.val + left[1] + right[1];
        final var notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robRoot, notRobRoot};
    }
}
