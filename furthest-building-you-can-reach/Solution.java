class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final var minHeap = new PriorityQueue<Integer>();
        for (var i = 0; i < heights.length-1; i++) {
            final var diff = heights[i+1] - heights[i];
            if (0 < diff) {
                minHeap.offer(diff);
                if (ladders < minHeap.size()) {
                    bricks -= minHeap.poll();
                    if (bricks < 0) return i;
                }
            }
        }
        return heights.length-1;
    }
}
