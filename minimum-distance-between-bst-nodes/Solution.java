class Solution {
    private Integer prev;
    private int minDiff;

    public Solution() {
        prev = null;
        minDiff = Integer.MAX_VALUE;
    }

    public int minDiffInBST(TreeNode root) {
        aux(root);
        return minDiff;
    }

    private void aux(TreeNode root) {
        if (root == null) return;
        aux(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;
        aux(root.right);
    }
}
