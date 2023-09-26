class Solution {
    public int kthSmallest(int[][] matrix, int k) { // O((N+k)*log(N))
        final var N = matrix.length;
        if (N*N < k) return -1;
        // [row, col]
        final var minHeap = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));
        
        for (var i = 0; i < N; i++) minHeap.offer(new int[]{i, 0}); // O(N*log(N))
        while (1 < k--) { // O(k*log(N))
            final var curr = minHeap.poll();
            if (N <= ++curr[1]) continue;
            minHeap.offer(curr);
        }
        
        final var res = minHeap.peek();
        return matrix[res[0]][res[1]];
    }
}