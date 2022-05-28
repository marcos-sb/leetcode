class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        var i = 0;
        var removals = 0;
        for (var j = 1; j < intervals.length; j++)
            if (intervals[j][0] < intervals[i][1]) removals++;
            else i = j;
        return removals;
    }
}
