class Solution {
  public ListNode swapInPairs(ListNode head) {
    return swap(head, head.next);
  }

  private static ListNode swap(ListNode prev, ListNode curr) {
    if (prev == null && curr == null) return null;
    if (prev != null && curr == null) return prev;
    
    final ListNode next = curr.next;
    final ListNode nextnext = next == null ? null : next.next;
    curr.next = prev;
    prev.next = swap(next, nextnext);
    return curr;
  }
}
