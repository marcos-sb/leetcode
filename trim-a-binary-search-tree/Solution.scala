object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
    if (root == null) return null
    if (L < root.value) {
      root.left = trimBST(root.left, L, R)
    } else root.left = null
    if (root.value < R) {
      root.right = trimBST(root.right, L, R)
    } else root.right = null
    if (L <= root.value && root.value <= R) return root
    if (root.value < L) return root.right
    if (R < root.value) return root.left
    null
  }
}