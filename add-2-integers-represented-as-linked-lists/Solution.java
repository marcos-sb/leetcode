class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final int lenL1 = len(l1);
    final int lenL2 = len(l2);
    int diff = lenL1 - lenL2;
    ListNode longest, shortest;
    if (diff < 0) {
      longest = l2;
      shortest = l1;
    } else {
      longest = l1;
      shortest = l2;
    }

    final ListNode head = new ListNode(-1);
    ListNode tail = head;
    int carry = 0;
    while (longest != null) {
      if (shortest == null) shortest = new ListNode(0);
      final int sum = longest.val + shortest.val + carry;
      carry = sum / 10;
      final ListNode newNode = new ListNode(sum % 10);
      tail.next = newNode;
      tail = newNode;
      longest = longest.next;
      shortest = shortest.next;
    }

    if (carry > 0) {
      final ListNode newNode = new ListNode(carry);
      tail.next = newNode;
      tail = newNode;
    }

    return head.next;
  }

  private static int len(ListNode node) {
    int len = 0;
    while (node != null) {
      node = node.next;
    }
    return len;
  }
}
