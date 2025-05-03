class Solution {
    public int rob(TreeNode root) {
        final var res = aux(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] aux(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        final var left = aux(root.left);
        final var right = aux(root.right);

        final var rob = root.val + left[1] + right[1];
        final var notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}
