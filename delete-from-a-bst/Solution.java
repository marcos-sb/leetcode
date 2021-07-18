class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        final TreeNode[] toDelete = find(null, root, key);
        if (toDelete[1] == null) return root;
        final TreeNode replacement = delete(toDelete[1]);
        if (toDelete[0] == null) return replacement;
        if (toDelete[1].val < toDelete[0].val)
            toDelete[0].left = replacement;
        else
            toDelete[0].right = replacement;
        return root;
    }
    
    private static TreeNode[] find(TreeNode parent, TreeNode node, int key) {
        if (node == null) return new TreeNode[]{parent, null};
        if (node.val == key) return new TreeNode[]{parent, node};
        final TreeNode[] searchLeft = find(node, node.left, key);
        if (searchLeft[1] != null) return searchLeft;
        final TreeNode[] searchRight = find(node, node.right, key);
        return searchRight;
    }
    
    private static TreeNode delete(TreeNode node) {
        if (node.right == null) return node.left;
        final TreeNode leftMost = findLeftmost(node.right);
        leftMost.left = node.left;
        return node.right;
    }
    
    private static TreeNode findLeftmost(TreeNode node) {
        if (node == null) return null;
        final TreeNode left = findLeftmost(node.left);
        if (left == null) return node;
        return left;
    }
}
