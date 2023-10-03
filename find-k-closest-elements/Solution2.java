class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final var N = arr.length;
        final var dist = new int[N][2];
        for (var i = 0; i < N; i++) { // O(N)
            dist[i][0] = Math.abs(arr[i] - x);
            dist[i][1] = i;
        }
        
        final Comparator<int[]> cmp = (a,b) -> {
            final var dCmp = Integer.compare(a[0], b[0]);
            return dCmp == 0 ? Integer.compare(a[1], b[1]) : dCmp;
        };
        Arrays.sort(dist, cmp); // O(N*log(N))
        
        final var res = new ArrayList<Integer>(k);
        for (var i = 0; i < k; i++) // O(k)
            res.add(arr[dist[i][1]]);
        Collections.sort(res); // O(k*log(k))
        
        return res;
    }
}