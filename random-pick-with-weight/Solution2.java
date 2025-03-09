class Solution {
    private final Random rnd;
    private final int[] runningSum;
    private final int N;

    public Solution(int[] w) {
        rnd = new Random();
        N = w.length;
        runningSum = new int[N];
        runningSum[0] = w[0];
        for (var i = 1; i < w.length; i++) {
            runningSum[i] = runningSum[i-1] + w[i];
        }
    }

    public int pickIndex() {
        final var sum = rnd.nextInt(runningSum[N-1]);
        var lo = 0;
        var hi = N-1;
        while (lo < hi) {
            final var mid = (hi-lo)/2 + lo;
            if (runningSum[mid] <= sum) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}
