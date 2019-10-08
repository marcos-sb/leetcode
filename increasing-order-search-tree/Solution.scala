object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def increasingBST(root: TreeNode): TreeNode = {
    if (root == null) return null
    return iBST(null, root)
  }
  def iBST(parent: TreeNode, node: TreeNode): TreeNode = {
    if (node == null) return null
    if (node.right != null)
      node.right = iBST(parent, node.right)
    else node.right = parent
    if (node.left != null) {
      val tmp = iBST(node, node.left)
      node.left = null
      return tmp
    }
    return node
  }
}