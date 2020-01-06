/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def deepestLeavesSum(root: TreeNode): Int = {
    def go(node: TreeNode, level: Int): (Int,Int) = {
      if (node == null) return (0, level)
      if (node.left == null && node.right == null) {
        return (node.value, level)
      }
      val _left = go(node.left, level+1)
      val _right = go(node.right, level+1)
      if (_left._2 < _right._2) return _right
      else if (_right._2 < _left._2) return _left
      else return (_left._1 + _right._1, _left._2)
    }
    go(root, 0)._1
  }
}