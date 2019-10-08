object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def isUnivalTree(root: TreeNode): Boolean = {
    def go(node: TreeNode, value: Int): Boolean = {
      if (node == null) return true
      if (node.value != value) return false
      return go(node.left, node.value) && go(node.right, node.value)
    }
    return go(root.left, root.value) && go(root.right, root.value)
  }
}