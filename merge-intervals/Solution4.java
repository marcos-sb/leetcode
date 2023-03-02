class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Arrays::compare);
        
        final var res = new ArrayList<int[]>();
        var prev = intervals[0];
        for (var i = 1; i < intervals.length; i++) {
            final var interval = intervals[i];
            if (overlapping(prev, interval)) {
                prev[0] = Math.min(interval[0], prev[0]);
                prev[1] = Math.max(interval[1], prev[1]);
            } else {
                res.add(prev);
                prev = interval;
            }
        }

        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }

    private static boolean overlapping(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }
}
