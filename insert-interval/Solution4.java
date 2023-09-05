class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final var N = intervals.length;
        final var res = new ArrayList<int[]>();
        
        for (var interval : intervals) {
            if (newInterval == null) {
                res.add(interval);
            } else if (newInterval[0] <= interval[1] && interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else if (interval[0] <= newInterval[0]) {
                res.add(interval);
            } else {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
        }
        if (newInterval != null) res.add(newInterval);
        
        return res.toArray(new int[0][2]);
    }
}
