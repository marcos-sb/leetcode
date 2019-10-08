object Solution {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  def middleNode(head: ListNode): ListNode = {
    if (head == null) return null
    var current = head
    var i = 0
    do {
      i += 1
    } while ({current = current.next; current != null})
    current = head
    for (_ <- 0 until i/2) {
      current = current.next
    }
    current
  }
}