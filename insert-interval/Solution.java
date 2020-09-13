class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length != 2) return intervals;
        
        final var ret = new ArrayList<int[]>();
        var mergedInterval = newInterval;
        for (int i = 0; i < intervals.length; i++) {
            if (mergedInterval[0] <= intervals[i][1] && intervals[i][0] <= mergedInterval[1]) {
                mergedInterval = merge(intervals[i], mergedInterval);
            } else if (mergedInterval[1] < intervals[i][0]) {
                ret.add(mergedInterval);
                for (int j = i; j < intervals.length; j++) ret.add(intervals[j]);
                return ret.toArray(new int[0][]);
            } else ret.add(intervals[i]);
        }
        ret.add(mergedInterval);
        
        return ret.toArray(new int[0][]);
    }

    private static int[] merge(int[] i1, int[] i2) {
        return new int[]{Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
    }
}
