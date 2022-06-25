class Solution {
    static class UnionFind {
        int[] id;
        int classCount;
        UnionFind(int classes) {
            this.id = new int[classes];
            for (var i = 0; i < classes; i++) id[i] = i;
            classCount = classes;
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
            if (ida == idb) return;
            classCount--;
            id[idb] = ida;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        final var N = isConnected.length;
        final var uf = new UnionFind(N);
        
        for (var i = 0; i < N; i++)
            for (var j = i+1; j < N; j++)
                if (isConnected[i][j] == 1) uf.union(i,j);
        
        return uf.classCount;
    }
}
