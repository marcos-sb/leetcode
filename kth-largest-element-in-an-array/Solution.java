class Solution {
    public int findKthLargest(int[] nums, int k) {
        final var N = nums.length;
        final var minHeap = new PriorityQueue<Integer>();
        for (var n : nums) { // O(N * log(k))
            minHeap.offer(n);
            if (k < minHeap.size()) minHeap.poll();
        }
        return minHeap.peek();
    }
}
