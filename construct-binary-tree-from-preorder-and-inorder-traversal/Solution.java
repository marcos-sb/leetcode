class Solution {
    private int curr;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curr = 0;
        final var N = preorder.length;
        final var inorderPos = new HashMap<Integer, Integer>(inorder.length);
        for (var i = 0; i < inorder.length; i++)
            inorderPos.put(inorder[i], i);
        return aux(preorder, inorder, 0, N-1, inorderPos);
    }

    private TreeNode aux(int[] pre, int[] in, int lo, int hi, Map<Integer, Integer> pos) {
        if (hi < lo) return null;
        if (hi == lo) return new TreeNode(pre[curr++]);
        final var val = pre[curr++];
        final var valI = pos.get(val);
        final var root = new TreeNode(val);
        root.left = aux(pre, in, lo, valI-1, pos);
        root.right = aux(pre, in, valI+1, hi, pos);
        return root;
    }
}
