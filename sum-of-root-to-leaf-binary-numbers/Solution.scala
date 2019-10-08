object Solution {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
  def sumRootToLeaf(root: TreeNode): Int = {
    var totalSum = 0
    def go(root: TreeNode, sumPath:Int): Unit = {
      if (root == null) return
      val newSumPath = sumPath*2 + root.value
      if (root.left == null && root.right == null) {
        totalSum += newSumPath
        return
      }
      go(root.left, newSumPath)
      go(root.right, newSumPath)
    }
    go(root, 0)
    totalSum
  }
}