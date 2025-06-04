class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{nums[0], 0});

        int maxScore = nums[0];

        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < i - k) {
                pq.poll();
            }

            maxScore = pq.peek()[0] + nums[i];
            pq.offer(new int[]{maxScore, i});
        }

        return maxScore;
    }
}
