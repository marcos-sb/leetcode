class Solution {
    private static class UnionFind {
        int[] clazz;
        UnionFind(int size) {
            clazz = new int[size];
            for (var i = 0; i < size; ++i) {
                clazz[i] = i;
            }
        }
        boolean union(int a, int b) {
            final var classA = find(a-1);
            final var classB = find(b-1);
            if (classA != classB) {
                clazz[classA] = classB;
                return true;
            }
            return false;
        }
        int find(int a) {
            var classA = clazz[a];
            while (clazz[classA] != classA) {
                clazz[classA] = clazz[clazz[classA]];
                classA = clazz[classA];
            }
            return classA;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        final var N = edges.length;
        final var uf = new UnionFind(N);
        for (var e : edges) {
            if (!uf.union(e[0], e[1]))
                return e;
        }
        return new int[]{-1,-1};
    }
}
