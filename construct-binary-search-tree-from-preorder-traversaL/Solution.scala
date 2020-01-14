object Solution {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    def go(i: Int, p: TreeNode, ancestor: TreeNode): Int = {
      if (preorder.length <= i) return i
      var _i = i
      if (preorder(_i) < p.value) {
        p.left = new TreeNode(preorder(_i))
        _i = go(_i+1, p.left, p)
      }
      if (preorder.length <= _i) return _i
      if (ancestor == null || preorder(_i) < ancestor.value
        || (ancestor.value < p.value && p.value < preorder(_i))) {
        p.right = new TreeNode(preorder(_i))
        _i = go(_i+1, p.right, ancestor)
      }
      _i
    }
    val root = new TreeNode(preorder(0))
    go(1, root, null)
    root
  }
}