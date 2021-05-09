public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return is(root.left, root.right);
    }

    private static boolean is(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return (left == null) == (right == null);
        if (left.val != right.val) return false;
        return is(left.left, right.right) && is(left.right, right.left);
    }
}
