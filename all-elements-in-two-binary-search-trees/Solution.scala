/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  import collection.mutable
  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
    merge(inOrder(root1, mutable.Buffer[Int]()),
      inOrder(root2, mutable.Buffer[Int]())).toList
  }
  private [this]
  def inOrder(node: TreeNode, _inOrder: mutable.Buffer[Int]): mutable.Buffer[Int] = {
    if (node == null) return _inOrder
    inOrder(node.left, _inOrder)
    _inOrder += node.value
    inOrder(node.right, _inOrder)
    return _inOrder
  }
  private [this] def merge(s1: Seq[Int], s2: Seq[Int]): Seq[Int] = {
    val it1 = s1.iterator
    val it2 = s2.iterator
    val buf = mutable.Buffer[Int]()
    var _v1 = if (it1.hasNext) { Some(it1.next) } else { None }
    var _v2 = if (it2.hasNext) { Some(it2.next) } else { None }
    while (_v1.isDefined || _v2.isDefined) {
      if (_v1.isEmpty) {
        buf += _v2.get
        _v2 = if (it2.hasNext) { Some(it2.next) } else { None }
      } else if (_v2.isEmpty) {
        buf += _v1.get
        _v1 = if (it1.hasNext) { Some(it1.next) } else { None }
      } else if (_v1.get < _v2.get) {
        buf += _v1.get
        _v1 = if (it1.hasNext) { Some(it1.next) } else { None }
      } else {
        buf += _v2.get
        _v2 = if (it2.hasNext) { Some(it2.next) } else { None }
      }
    }
    buf
  }
}