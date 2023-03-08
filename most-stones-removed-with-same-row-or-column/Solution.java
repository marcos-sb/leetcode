class Solution {
    class UF {
        int[] id;
        int[] sz;
        UF(int n) {
            sz = new int[n];
            id = new int[n];
            for (var i = 0; i < n; i++) {
                sz[i] = 1;
                id[i] = i;
            }
        }
        void union(int a, int b) {
            final var ida = find(a);
            final var idb = find(b);
            if (ida == idb) return;
            id[ida] = idb;
            sz[idb] += sz[ida];
        }
        int find(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }
        int size(int a) {
            return sz[a];
        }
    }
    
    public int removeStones(int[][] stones) {
        final var N = stones.length;
        final var rows = new HashMap<Integer, Integer>();
        final var cols = new HashMap<Integer, Integer>();
        final var uf = new UF(N);
        
        for (var i = 0; i < N; i++) {
            final var si = stones[i];
            if (rows.containsKey(si[0])) uf.union(i, rows.get(si[0]));
            else rows.put(si[0], i);
            if (cols.containsKey(si[1])) uf.union(i, cols.get(si[1]));
            else cols.put(si[1], i);
        }

        var removed = 0;
        final var visited = new boolean[N];
        for (var i = 0; i < N; i++) {
            final var idi = uf.find(i);
            if (visited[idi]) continue;
            removed += uf.size(idi) - 1;
            visited[idi] = true;
        }

        return removed;
    }
}
