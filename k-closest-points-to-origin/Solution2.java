class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var d = new int[points.length];
        int i = 0;
        for (var p : points) d[i++] = dist00(p);
        
        final var kSmallestDist = quickSelect(d, 0, d.length-1, k-1);
        
        final var res = new int[k][];
        i = 0;
        for (var p : points)
            if (dist00(p) <= kSmallestDist)
                res[i++] = p;
        
        return res;
    }
    
    private static int dist00(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
    
    private static int quickSelect(int[] ds, int lo, int hi, int k) {
        final var pivotI = ThreadLocalRandom.current().nextInt(lo, hi+1);
        swap(ds, pivotI, hi);
        
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (ds[j] < ds[hi]) {
                swap(ds, i, j);
                i++;
            }
        }
        swap(ds, i, hi);
        
        if (k < i) return quickSelect(ds, lo, i-1, k);
        if (k > i) return quickSelect(ds, i+1, hi, k);
        return ds[i];
    }
    
    private static void swap(int[] ds, int i, int j) {
        final var tmp = ds[i];
        ds[i] = ds[j];
        ds[j] = tmp;
    }
}
