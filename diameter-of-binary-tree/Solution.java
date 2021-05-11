public class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return diameter;
    }

    private int maxPath(TreeNode node) {
        if (node == null) return 0;
        final int mpl = maxPath(node.left);
        final int mpr = maxPath(node.right);
        diameter = Math.max(diameter, mpl + mpr);
        return 1 + Math.max(mpl, mpr);
    }
}
