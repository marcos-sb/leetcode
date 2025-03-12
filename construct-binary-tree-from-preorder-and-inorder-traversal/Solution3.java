class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final var inOrderMap = new HashMap<Integer, Integer>();
        var i = 0;
        for (var val : inorder) {
            inOrderMap.put(val, i++);
        }
        return aux(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inOrderMap);
    }

    private static TreeNode aux(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi, Map<Integer, Integer> inOrderMap) {
        if (preHi < preLo || inHi < inLo) return null;

        final var root = new TreeNode(preorder[preLo]);
        final var inIndex = inOrderMap.get(root.val);

        final var leftSubtreeSize = inIndex - inLo;
        root.left = aux(preorder, preLo+1, preLo+leftSubtreeSize, inorder, inLo, inIndex-1, inOrderMap);
        root.right = aux(preorder, preLo+leftSubtreeSize+1, preHi, inorder, inIndex+1, inHi, inOrderMap);

        return root;
    }
}
