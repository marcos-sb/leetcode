class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final var N = arr.length;
        
        var lo = 0;
        var hi = N-k; // leave k elements to the right of mid for the comparison in :9
        while (lo < hi) { // O(log(N))
            final var mid = lo + (hi-lo)/2;
            if (x-arr[mid] <= arr[mid+k]-x) hi = mid;
            else lo = mid+1;
        }

        final var res = new ArrayList<Integer>(k);
        for (var i = lo; i < lo+k; i++) res.add(arr[i]);
        return res;
    }
}
