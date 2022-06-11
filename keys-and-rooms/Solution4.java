class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final var N = rooms.size();
        final var visited = new boolean[N];
        final var q = new LinkedList<Integer>();
        
        q.offer(0);
        visited[0] = true;
        var visitedCount = 1;
        while (!q.isEmpty()) {
            final var curr = q.poll();
            for (var rk : rooms.get(curr)) {
                if (visited[rk]) continue;
                visited[rk] = true;
                if (visitedCount++ == N) return true;
                q.offer(rk);
            }
        }
        
        return visitedCount == N;
    }
}
