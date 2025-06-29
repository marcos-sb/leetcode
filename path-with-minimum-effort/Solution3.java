class Solution {
    private final int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int minimumEffortPath(int[][] heights) {
        final var rows = heights.length;
        final var cols = heights[0].length;

        final var minEffort = new int[rows][cols];
        for (var r = 0; r < rows; ++r)
            Arrays.fill(minEffort[r], Integer.MAX_VALUE);

        final var minHeap = new PriorityQueue<Cell>((a,b) -> a.e() - b.e());
        minHeap.offer(new Cell(0, 0, 0));
        minEffort[0][0] = 0;

        while (!minHeap.isEmpty()) {
            final var curr = minHeap.poll();
            final var r = curr.r();
            final var c = curr.c();
            final var e = curr.e();

            if (r == rows-1 && c == cols-1) return e;
            if (minEffort[r][c] < e) continue;

            for (var move : moves) {
                final var newR = r + move[0];
                final var newC = c + move[1];
                if (outside(heights, newR, newC)) continue;
                final var newE = Math.max(e, Math.abs(heights[r][c] - heights[newR][newC]));
                if (newE < minEffort[newR][newC]) {
                    minHeap.offer(new Cell(newR, newC, newE));
                    minEffort[newR][newC] = newE;
                }
            }
        }

        return -1;
    }

    private static boolean outside(int[][] h, int r, int c) {
        return r < 0 || c < 0 || h.length <= r || h[0].length <= c;
    }

    private static record Cell(int r, int c, int e) {}
}
