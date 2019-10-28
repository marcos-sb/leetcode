package average_of_levels_in_binary_tree

import collection.mutable.ArrayBuffer

object Solution {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def averageOfLevels(root: TreeNode): Array[Double] = {
    levels(root, ArrayBuffer(), 0).map(avg).toArray
  }
  def levels(root: TreeNode, _levels: ArrayBuffer[ArrayBuffer[Long]], lvl: Int): ArrayBuffer[ArrayBuffer[Long]] = {
    if (root == null) return _levels
    if (_levels.length == lvl) {
      _levels += ArrayBuffer()
    }
    _levels(lvl) += root.value
    levels(root.left, _levels, lvl+1)
    levels(root.right, _levels, lvl+1)
  }
  def avg(nums: ArrayBuffer[Long]): Double = nums.sum.toDouble / nums.length
}
