object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {
    def go(node:TreeNode, sum:Int): Int = {
      if (node == null) return sum
      if (node.value >= L && node.value <= R)
        go(node.right, go(node.left, sum+node.value))
      else go(node.right, go(node.left, sum))
    }
    go(root, 0)
  }
}