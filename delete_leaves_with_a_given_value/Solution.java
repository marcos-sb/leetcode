package delete_leaves_with_a_given_value;

class Solution {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null) {
            if (root.val == target) return null;
            return root;
        }
        return root;
    }
}
