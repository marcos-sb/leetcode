/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode add(ListNode l1, ListNode l2, int carry) {

        if(l1 == null && l2 == null && carry == 0) return null;

        int val1 = 0;
        ListNode l1next = null;
        if(l1 != null) {
            val1 = l1.val;
            l1next = l1.next;
        }
        int val2 = 0;
        ListNode l2next = null;
        if(l2 != null) {
            val2 = l2.val;
            l2next = l2.next;
        }

        final int val = val1 + val2 + carry;

        final int newCarry = val / 10;
        final int defVal = val % 10;
        ListNode ln = new ListNode(defVal);
        ln.next = add(l1next,l2next,newCarry);

        return ln;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }
}
