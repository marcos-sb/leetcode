class Solution {
    private final int[] runningSum;
    private final Random rnd;

    public Solution(int[] w) {
        final var N = w.length;
        rnd = new Random();
        for (var i = 1; i < N; i++) w[i] += w[i-1];
        runningSum = w;
    }

    public int pickIndex() {
        final var N = runningSum.length;
        final var max = runningSum[N-1];
        final var target = rnd.nextInt(max) + 1;
        var lo = 0;
        var hi = N-1;
        while (lo < hi) {
            final var mid = lo + (hi-lo)/2;
            if (target < runningSum[mid]) hi = mid;
            else if (runningSum[mid] < target) lo = mid+1;
            else return mid;
        }
        return lo;
    }
}
