class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        final var K = lists.length;
        if (K == 0) return null;

        var n = K;
        while (1 < n) { // O(M * log(K))
            var j = 0;
            for (var i = 0; i+1 < n; i+=2)
                lists[j++] = merge(lists[i], lists[i+1]); // O(M), M <- max(len(lists))
            if (n % 2 != 0) {
                lists[j] = lists[n-1];
                n = n/2 + 1;
            } else n /= 2;
        }

        return lists[0];
    }

    private static ListNode merge(ListNode h1, ListNode h2) { // O(len(h1) + len(h2))
        final var dummyHead = new ListNode(0);
        var last = dummyHead;
        while (h1 != null || h2 != null) {
            ListNode next;
            if (h1 == null) next = h2;
            else if (h2 == null) next = h1;
            else if (h1.val < h2.val) next = h1;
            else next = h2;
            
            if (h1 == next) h1 = next.next;
            else h2 = next.next;

            last.next = next;
            last = next;
        }
        
        return dummyHead.next;
    }
}
