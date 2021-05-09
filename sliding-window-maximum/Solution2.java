class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final var q = new ArrayDeque<Integer>();
        int l = 0;
        int r = 0;
        for (; r < k; r++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r])
                q.pollLast();
            q.offerLast(r);
        }
        
        int i = 0;
        final var res = new int[nums.length-k+1];
        res[l++] = nums[q.peekFirst()];
        while (r < nums.length) {
            if (q.peekFirst() < l) q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r])
                q.pollLast();
            q.offerLast(r);
            res[l++] = nums[q.peekFirst()];
            r++;
        }
        
        return res;
    }
}
