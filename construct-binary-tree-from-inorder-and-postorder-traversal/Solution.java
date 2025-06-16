class Solution {
    private int postIdx;
    private final Map<Integer, Integer> inIdxByValue;

    public Solution() {
        this.inIdxByValue = new HashMap<>();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final var n = inorder.length;
        this.postIdx = n-1;

        for (var i = 0; i < n; ++i) {
            inIdxByValue.put(inorder[i], i);
        }

        return helper(postorder, 0, n-1);
    }

    public TreeNode helper(int[] postorder, int inStart, int inEnd) {
        if (inEnd < inStart) {
            return null;
        }

        final var rootVal = postorder[postIdx--];
        final var root = new TreeNode(rootVal);
        final var inOrderRootI = inIdxByValue.get(rootVal);

        root.right = helper(postorder, inOrderRootI+1, inEnd);
        root.left = helper(postorder, inStart, inOrderRootI-1);

        return root;
    }
}
