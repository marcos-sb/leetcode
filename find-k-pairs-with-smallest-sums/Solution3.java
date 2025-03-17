class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[2], b[2]));
        for (var i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{i, 0, nums1[i]+nums2[0]});
        }

        final List<List<Integer>> res = new ArrayList<>();
        for (var i = 0; i < k; i++) {
            if (minHeap.isEmpty()) break;
            final var top = minHeap.poll();
            res.add(List.of(nums1[top[0]], nums2[top[1]]));
            if (top[1] < nums2.length-1)
                minHeap.offer(new int[]{top[0], top[1]+1, nums1[top[0]] + nums2[top[1]+1]});
        }

        return res;
    }
}
