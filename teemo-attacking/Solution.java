class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length < 1 || duration == 0) return 0;
        var totalPoisoned = duration;
        var prev = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            final var diff = timeSeries[i] - prev;
            totalPoisoned += Math.min(diff, duration);
            prev = timeSeries[i];
        }
        return totalPoisoned;
    }
}
