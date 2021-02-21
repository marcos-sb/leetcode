class Solution {
    private static class P {
        int r, c, e;
        P(int r, int c, int e) {
            this.r = r;
            this.c = c;
            this.e = e;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (this == o) return true;
            if (!(o instanceof P)) return false;
            final var that = (P) o;
            return this.r == that.r && this.c == that.c; // ignore the effort
        }
        @Override
        public int hashCode() {
            return Objects.hash(r,c);
        }
    }
    
    private static P[] movs = new P[]{new P(1,0,0), new P(0,1,0), new P(-1,0,0), new P(0,-1,0)};
    
    public int minimumEffortPath(int[][] heights) {
        final var src = new P(0,0,0);
        if (!valid(heights, src.r, src.c)) return -1;
        
        final var dst = new P(heights.length-1, heights[0].length-1, -1);
        final var q = new PriorityQueue<P>((p1,p2) -> p1.e - p2.e);
        final var visited = new HashSet<P>();
        
        int effort = src.e;
        q.offer(src);
        while (!q.isEmpty()) {
            final var currPos = q.poll();
            visited.add(currPos);
            effort = Math.max(currPos.e, effort);
            if (currPos.equals(dst)) return effort;
            for (P nPos : neighbours(heights, currPos)) {
                if (visited.contains(nPos)) continue;
                q.offer(nPos);
            }
        }
        
        return -1;
    }
            
    private static boolean valid(int[][] h, int r, int c) {
        if (r < 0 || h.length <= r || c < 0 || h[0].length <= c)
            return false;
        return true;
    }
    
    private static List<P> neighbours(int[][] h, P pos) {
        if (!valid(h, pos.r, pos.c)) return List.of();
        final List<P> ret = new ArrayList<>(movs.length);
        for (P m : movs) {
            final var newR = pos.r+m.r;
            final var newC = pos.c+m.c;
            if (!valid(h, newR, newC)) continue;
            final var newPos = new P(newR, newC, Math.abs(h[pos.r][pos.c] - h[newR][newC]));
            ret.add(newPos);
        }
        return ret;
    }
}
