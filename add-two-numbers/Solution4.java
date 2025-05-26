/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var dummyHead = new ListNode();
        var tail = dummyHead;
        var carry = 0;

        while (l1 != null || l2 != null) {
            final var l1val = l1 == null ? 0 : l1.val;
            final var l2val = l2 == null ? 0 : l2.val;
            final var sum = l1val + l2val + carry;
            final var digitVal = sum % 10;
            carry = sum / 10;
            tail.next = new ListNode(digitVal);
            tail = tail.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (0 < carry) {
            tail.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
