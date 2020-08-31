class Solution {
    private static TreeNode deleteRightMost(TreeNode node, TreeNode parent) {
        if (node == null) return null;
        if (node.right == null) {
            if (parent != null) parent.right = node.left;
            return node;
        }
        return deleteRightMost(node.right, node);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            final TreeNode newVal = deleteRightMost(root.left, null);
            if (newVal == null) return root.right;
            if (newVal == root.left) {
                newVal.right = root.right;
                root.right = null;
                return newVal;
            }
            root.val = newVal.val;
        }
        return root;
    }
}
