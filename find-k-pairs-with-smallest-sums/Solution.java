class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final var N = nums1.length;
        final var M = nums2.length;
        final var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[2], b[2]));
        final var seen = new HashSet<Pair<Integer,Integer>>();
        minHeap.offer(new int[]{0, 0, nums1[0]+nums2[0]});
        seen.add(new Pair<>(0,0));
        
        final List<List<Integer>> res = new ArrayList<>();
        while (!minHeap.isEmpty() && 0 < k--) {
            final var minSum = minHeap.poll();
            final var i = minSum[0];
            final var j = minSum[1];
            res.add(List.of(nums1[i], nums2[j]));

            final var p1 = new Pair<>(i+1, j);
            if (i+1 < N && !seen.contains(p1)) {
                minHeap.offer(new int[]{i+1, j, nums1[i+1]+nums2[j]});
                seen.add(p1);
            }
            final var p2 = new Pair<>(i, j+1);
            if (j+1 < M && !seen.contains(p2)) {
                minHeap.offer(new int[]{i, j+1, nums1[i]+nums2[j+1]});
                seen.add(p2);
            }
        }

        return res;
    }
}