class Solution {
    class UnionFind {
        int[] id;
        int classCount;
        UnionFind(int sz) {
            id = new int[sz];
            classCount = sz;
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
            final int ida = find(a);
            final int idb = find(b);
            if (ida != idb) {
                classCount--;
                id[ida] = idb;
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        final var uf = new UnionFind(isConnected.length);
        final var visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (visited[j] || i == j || isConnected[i][j] == 0) continue;
                uf.union(i,j);
            }
            visited[i] = true;
        }
        return uf.classCount;
    }
}
