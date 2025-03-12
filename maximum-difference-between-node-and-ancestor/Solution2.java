class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return aux(root, root.val, root.val);
    }
    private static int aux(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(aux(root.left, max, min), aux(root.right, max, min));
    }
}
