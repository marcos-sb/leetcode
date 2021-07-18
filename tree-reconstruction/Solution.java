class Solution {
  private int pi = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    final Map<Integer, Integer> inorderIdx = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIdx.put(inorder[i], i);
    }
    return buildTree(preorder, inorder, 0, inorder.length-1, inorderIdx);
  }

  private final TreeNode buildTree(int[] preorder, int[] inorder, int l, int r, Map<Integer, Integer> inorderIdx) {
    if (r < l) return null;
    final int val = preorder[pi++];
    final TreeNode newNode = new TreeNode(val);
    if (l == r) return newNode;
    final int newNodeInOrderIdx = inorderIdx.get(val);
    newNode.left = buildTree(preorder, inorder, l, newNodeInOrderIdx-1, inorderIdx);
    newNode.right = buildTree(preorder, inorder, newNodeInOrderIdx+1, r, inorderIdx);
    return newNode;
  }
}
