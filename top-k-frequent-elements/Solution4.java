class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var N = nums.length;
        final var freqsM = new HashMap<Integer, Integer>();
        for (var n : nums) freqsM.compute(n, (num, f) -> f == null ? 1 : f+1); // O(N)
        
        final var F = freqsM.size();
        final var freqsA = new int[F];
        var i = 0;
        for (var e : freqsM.entrySet()) freqsA[i++] = e.getValue(); // O(F)

        // F-k: because we want the top-kth position, which is the k-1th from the end of freqsA
        // k-1: would be for bottom-kth position
        final var kthFreq = freqsA[quickSelect(freqsA, F-k, 0, F-1)]; // O(F)

        final var res = new int[k];
        var j = 0;
        for (var e : freqsM.entrySet()) {
            if (kthFreq <= e.getValue()) res[j++] = e.getKey();
            if (j == k) break;
        }

        return res;
    }

    private static int quickSelect(int[] arr, int k, int lo, int hi) {
        final var pivotI = ThreadLocalRandom.current().nextInt(lo, hi+1);
        swap(arr, pivotI, hi);

        var j = lo;
        for (var i = lo; i < hi; i++)
            if (arr[i] <= arr[hi]) swap(arr, i, j++);
        swap(arr, j, hi);

        if (k < j) return quickSelect(arr, k, lo, j-1);
        if (j < k) return quickSelect(arr, k, j+1, hi);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        final var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
