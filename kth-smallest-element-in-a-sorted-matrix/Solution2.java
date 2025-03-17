class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final var minHeap = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[2], b[2])
        );
        for (var r = 0; r < matrix.length; r++)
            minHeap.offer(new int[]{r, 0, matrix[r][0]});
        while (1 < k--) {
            final var top = minHeap.poll();
            if (top[1] < matrix.length-1)
                minHeap.offer(new int[]{top[0], top[1]+1, matrix[top[0]][top[1]+1]});
        }
        return minHeap.peek()[2];
    }
}
