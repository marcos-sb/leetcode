class Solution {
    static class UnionFind {
        int components;
        final int[] id;
        UnionFind(int sz) {
            components = sz;
            id = new int[sz];
            for (int i = 0; i < sz; i++)
                id[i] = i;
        }
        int find(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }
        void union(int a, int b) {
            final var ida = find(a);
            final var idb = find(b);
            id[ida] = idb;
            if (ida != idb) components--;
        }
        boolean same(int a, int b) {
            return find(a) == find(b);
        }
    }
    
    public int minimumCost(int n, int[][] connections) {
        final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[2], b[2]);
        Arrays.sort(connections, cmp);
        
        final var uf = new UnionFind(n);
        int cost = 0;
        for (var conn : connections) {
            if (uf.same(conn[0]-1, conn[1]-1)) continue;
            uf.union(conn[0]-1, conn[1]-1);
            cost += conn[2];
        }
        
        return uf.components == 1 ? cost : -1;
    }
}
