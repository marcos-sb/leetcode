class Solution {
    private static class UnionFind {
        private final int[] provinceFor;
        int provinces;

        UnionFind(int size) {
            provinceFor = new int[size];
            for (var i = 0; i < size; ++i) {
                provinceFor[i] = i;
            }
            provinces = size;
        }

        void union(int cityA, int cityB) {
            final var provinceA = findProvince(cityA);
            final var provinceB = findProvince(cityB);
            if (provinceA == provinceB) return;
            provinceFor[provinceB] = provinceA;
            --provinces;
        }

        int findProvince(int city) {
            var province = provinceFor[city];
            while (provinceFor[province] != province) {
                provinceFor[province] = provinceFor[provinceFor[province]];
                province = provinceFor[province];
            }
            return province;
        }

        int provinces() {
            return provinces;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        final var N = isConnected.length;
        final var uf = new UnionFind(N);
        for (var r = 0; r < N; ++r) {
            for (var c = 0; c < N; ++c) {
                if (r == c) continue;
                if (isConnected[r][c] == 1) uf.union(r, c);
            }
        }
        return uf.provinces();
    }
}
