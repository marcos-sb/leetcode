class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final var N = intervals.length;
        var i = 0;
        while (i < N && intervals[i][1] < newInterval[0]) ++i;
        var j = i;
        while (j < N && newInterval[0] <= intervals[j][1] && intervals[j][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[j][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[j][1], newInterval[1]);
            ++j;
        }
        final var res = new int[i+1+intervals.length-j][2];
        System.arraycopy(intervals, 0, res, 0, i);
        res[i] = newInterval;
        System.arraycopy(intervals, j, res, i+1, intervals.length-j);
        return res;
    }
}
