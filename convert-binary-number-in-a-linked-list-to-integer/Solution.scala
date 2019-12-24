/**
 * Definition for singly-linked list.
 */
object Solution {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }
  def getDecimalValue(head: ListNode): Int = {
    var res = 0
    var n = head
    while (n != null) {
      res <<= 1
      res += n.x
      n = n.next
    }
    res
  }
}