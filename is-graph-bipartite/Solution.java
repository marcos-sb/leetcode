class Solution {
    public boolean isBipartite(int[][] graph) {
        final var color = new int[graph.length];
        final var q = new ArrayDeque<Integer>(graph.length);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;

            color[i] = 1;
            q.offerLast(i);
            while (!q.isEmpty()) {
                var size = q.size();
                while (size-- > 0) {
                    final var src = q.pollFirst();
                    for (var dst : graph[src]) {
                        if (color[dst] != 0 && color[dst] == color[src])
                            return false;
                        if (color[dst] == 0) {
                            color[dst] = -color[src];
                            q.offerLast(dst);
                        }
                    }
                }
            }
        }

        return true;
    }
}
