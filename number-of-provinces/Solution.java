class Solution {
    public int findCircleNum(int[][] isConnected) {
        final var q = new LinkedList<Integer>();
        final var visited = new boolean[isConnected.length];
        
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            provinces++;
            q.offer(i);
            while (!q.isEmpty()) {
                final var curr = q.poll();
                visited[i] = true;
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[curr][j] == 0 || visited[j]) continue;
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
        
        return provinces;
    }
}
