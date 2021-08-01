class Solution {
    static class UnionFind {
        int[] id;
        UnionFind(int sz) {
            id = new int[sz];
            for (int i = 0; i < sz; i++)
                id[i] = i;
        }
        
        int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        void union(int i, int j) {
            final int iid = find(i);
            final int jid = find(j);
            id[iid] = jid;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        
        final var uf = new UnionFind(n);
        int count = n;
        for (var e : edges) {
            final int id0 = uf.find(e[0]);
            final int id1 = uf.find(e[1]);
            if (id0 == id1) continue;
            uf.union(e[0], e[1]);
            count--;
        }
        return count;
    }
}
