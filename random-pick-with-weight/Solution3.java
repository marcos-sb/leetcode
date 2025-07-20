class Solution {
    private final Random rnd;
    private final int[] cumWeights;

    public Solution(int[] w) {
        this.rnd = new Random();
        this.cumWeights = new int[w.length];
        this.cumWeights[0] = w[0];
        for (var i = 1; i < w.length; ++i) {
            cumWeights[i] = cumWeights[i-1] + w[i];
        }
    }

    public int pickIndex() {
        final var n = cumWeights.length;
        final var max = cumWeights[n-1];
        final var target = rnd.nextInt(max);
        var lo = 0;
        var hi = n-1;
        while (lo < hi) {
            final var mid = lo + (hi-lo)/2;
            if (target < cumWeights[mid]) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}
