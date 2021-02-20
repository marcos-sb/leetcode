class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head, last;
        head = last = null;
        while (true) {
            var currMin = -1;
            for (int i = 0; i < lists.length; i++) {
                final var ln = lists[i];
                if (ln == null) continue;
                if (currMin == -1 || ln.val < lists[currMin].val)
                    currMin = i;
            }
            
            if (currMin == -1) break; // if all elements have been visited, finish
            
            if (last == null) {
                last = lists[currMin];
                head = last;
            } else {
                last.next = lists[currMin];
                last = lists[currMin];
            }
            
            lists[currMin] = lists[currMin].next;
        }
        
        return head;
    }
}
