class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final var N = nums1.length;
        final var M = nums2.length;
        final var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[2], b[2]));
        for (var i = 0; i < Math.min(k, N); i++)
            minHeap.offer(new int[]{i, 0, nums1[i]+nums2[0]});
        
        final List<List<Integer>> res = new ArrayList<>();
        while (!minHeap.isEmpty() && 0 < k--) {
            final var minSum = minHeap.poll();
            final var i = minSum[0];
            final var j = minSum[1];
            res.add(List.of(nums1[i], nums2[j]));
            if (j+1 < M) minHeap.offer(new int[]{i, j+1, nums1[i]+nums2[j+1]});
        }

        return res;
    }
}
