class Solution {
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    final var mid = findMid(head);

    final var left = mergeSort(head);
    final var right = mergeSort(mid);
    return merge(left, right);
  }

  private static ListNode merge(ListNode left, ListNode right) {
    if (left == right) return left;
    
    final var aux = new ListNode(-1);
    var auxLast = aux;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        auxLast.next = left;
        left = left.next;
      } else {
        auxLast.next = right;
        right = right.next;
      }
      auxLast = auxLast.next;
    }
    if (left == null) auxLast.next = right;
    else if (right == null) auxLast.next = left;

    return aux.next;
  }

  private static ListNode findMid(ListNode head) {
    ListNode prev = null;
    var curr = head;
    var curr2 = head;
    while (curr2 != null && curr2.next != null) {
      prev = curr;
      curr = curr.next;
      curr2 = curr2.next.next;
    }
    prev.next = null;
    return curr;
  }
}
