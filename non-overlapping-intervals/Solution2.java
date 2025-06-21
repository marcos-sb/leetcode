class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        final var n = intervals.length;
        if (n < 2) return 0;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        var prevEnd = intervals[0][1];
        var removals = 0;
        for (var i = 1; i < n; ++i) {
            final var currStart = intervals[i][0];
            if (currStart < prevEnd) {
                ++removals;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
