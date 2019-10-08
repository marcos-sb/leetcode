object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    leafs(root1, List()) == leafs(root2, List())
  }
  def isLeaf(node: TreeNode): Boolean = node.left == null && node.right == null
  def leafs(node: TreeNode, _leafs: List[Int]): List[Int] = {
    if (node == null) return _leafs
    if (isLeaf(node)) return node.value :: _leafs
    val _left = leafs(node.left, _leafs)
    leafs(node.right, _left)
  }
}