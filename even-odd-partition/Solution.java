class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;

    final var dummyHeadEven = new ListNode(-1);
    final var dummyHeadOdd = new ListNode(-1);
    ListNode lastEven = dummyHeadEven;
    ListNode lastOdd = dummyHeadOdd;

    int index = 0;
    while (head != null) {
      if (index % 2 == 0) {
        lastEven.next = head;
        lastEven = head;
      } else {
        lastOdd.next = head;
        lastOdd = head;
      }
      head = head.next;
      index++;
    }

    lastEven.next = dummyHeadOdd.next;
    lastOdd.next = null;

    return dummyHeadEven.next;
  }
}
