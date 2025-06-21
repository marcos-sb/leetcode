class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var n = points.length;
        final Pair<Integer, Double>[] dist = new Pair[n];

        for (var i = 0; i < n; ++i) {
            final var x = points[i][0];
            final var y = points[i][1];
            final var d = Math.sqrt(x*x + y*y);
            dist[i] = new Pair<>(i, d);
        }

        quickSelect(dist, 0, n-1, k-1);

        final var res = new int[k][];
        for (var i = 0; i < k; ++i) {
            res[i] = points[dist[i].getKey()];
        }

        return res;
    }

    private void quickSelect(Pair<Integer, Double>[] dist, int lo, int hi, int k) {
        if (hi <= lo) return;

        final var pivotI = ThreadLocalRandom.current().nextInt(lo, hi+1);
        swap(dist, pivotI, hi);

        var j = lo;
        for (var i = lo; i < hi; ++i) {
            if (dist[i].getValue() <= dist[hi].getValue())
                swap(dist, i, j++);
        }

        swap(dist, j, hi);

        if (j == k) return;
        if (k < j) quickSelect(dist, lo, j-1, k);
        else quickSelect(dist, j+1, hi, k);
    }

    private void swap(Pair<?, ?>[] dist, int i, int j) {
        final var tmp = dist[i];
        dist[i] = dist[j];
        dist[j] = tmp;
    }
}
