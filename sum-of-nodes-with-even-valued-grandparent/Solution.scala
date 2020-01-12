/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def sumEvenGrandparent(root: TreeNode): Int = {
    if (root == null) return 0
    return sumGP(root.left, -1, root.value) +
      sumGP(root.right, -1, root.value)
  }
  private [this] def sumGP(node: TreeNode, gpValue: Int, pValue: Int): Int = {
    if (node == null) return 0
    val _value = if (gpValue % 2 == 0) node.value
    else 0
    return sumGP(node.left, pValue, node.value) +
      sumGP(node.right, pValue, node.value) + _value
  }
}