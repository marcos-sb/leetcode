class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final var N = arr.length;
        if (k == N) return listOf(arr, 0, N-1);
        if (x < arr[0]) return listOf(arr, 0, k-1);
        if (arr[N-1] < x) return listOf(arr, N-k, N-1);
        
        final var insI = binarySearch(arr, x); // O(log(N))
        
        var l = insI-1;
        var r = l+1; // <-----------------------
        while (0 < k--) {
            if (l < 0) r++;
            else if (N <= r) l--;
            else if (d(arr[l],x) < d(arr[r],x)) l--;
            else if (d(arr[r],x) < d(arr[l],x)) r++;
            else l--;
        }
        
        return listOf(arr, l+1, r-1);
    }

    private static List<Integer> listOf(int[] arr, int l, int r) {
        final var res = new ArrayList<Integer>(r-l+1);
        for (var i = l; i <= r; i++) res.add(arr[i]);
        return res;
    }

    private static int binarySearch(int[] arr, int target) {
        final var N = arr.length;
        var lo = 0;
        var hi = N-1;
        while (lo <= hi) {
            final var mid = lo + (hi-lo)/2;
            if (target < arr[mid]) hi = mid-1;
            else if (arr[mid] < target) lo = mid+1;
            else return mid;
        }
        return lo;
    }

    private static int d(int a, int b) {
        return Math.abs(a-b);
    }
}
