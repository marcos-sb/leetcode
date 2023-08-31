class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final var N = nums.length;
        final var dq = new ArrayDeque<Integer>();
        final var res = new ArrayList<Integer>(N-k+1);
        for (var i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);
        for (var i = k; i < N; i++) {
            if (dq.peekFirst() == i-k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
