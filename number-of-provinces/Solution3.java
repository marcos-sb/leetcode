class Solution {
    public int findCircleNum(int[][] isConnected) {
        final var N = isConnected.length;
        final var q = new ArrayDeque<Integer>(N);
        final var visited = new boolean[N];
        var count = 0;
        for (var start = 0; start < N; start++) {
            if (visited[start]) continue;
            count++;
            q.offer(start);
            visited[start] = true;
            while (!q.isEmpty()) {
                final var curr = q.poll();
                for (var i = 0; i < N; i++) {
                    if (i == curr || visited[i] || isConnected[curr][i] == 0) continue;
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        
        return count;
    }
}
