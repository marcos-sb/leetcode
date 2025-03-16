class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        var curr = 0;
        for (var i = 1; i < intervals.length; i++) {
            if (intervals[curr][1] >= intervals[i][0]) {
                intervals[curr][0] = Math.min(intervals[curr][0], intervals[i][0]);
                intervals[curr][1] = Math.max(intervals[curr][1], intervals[i][1]);
            } else {
                intervals[++curr] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, curr+1);
    }
}
