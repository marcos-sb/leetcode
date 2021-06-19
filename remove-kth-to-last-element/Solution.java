class Solution {
  public ListNode removeKthToLast(ListNode head, int k) {
    if (head == null) return null;
    if (k <= 0) return head;

    var kptr = head;
    while (k-- > 0 && kptr != null)
      kptr = kptr.next;
    
    if (k > 0) return head;
    
    ListNode prev = null;
    var curr = head;
    while (curr != null && kptr != null) {
      prev = curr;
      curr = curr.next;
      kptr = kptr.next;
    }
    if (prev != null) {
      prev.next = curr.next;
      return head;
    }

    return head.next;
  }
}
