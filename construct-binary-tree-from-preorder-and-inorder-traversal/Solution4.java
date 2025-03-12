class Solution {
    private int p;
    private int i;

    public Solution() {
        p = 0; i = 0;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return aux(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode aux(int[] preorder, int[] inorder, int stop) {
        if (preorder.length <= p) return null;
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        final var root = new TreeNode(preorder[p++]);
        root.left = aux(preorder, inorder, root.val);
        root.right = aux(preorder, inorder, stop);

        return root;
    }
}
