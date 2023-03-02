class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final var res = new ArrayList<int[]>();
        for (var interval : intervals) {
            if (newInterval == null) {
                res.add(interval);
            } else if (overlapping(interval, newInterval)) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else if (interval[0] <= newInterval[0]) {
                res.add(interval);
            } else  {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
        }

        if (newInterval != null) res.add(newInterval);

        final var resArr = new int[res.size()][2];
        for (var i = 0; i < res.size(); i++) resArr[i] = res.get(i);
        
        return resArr;
    }

    private static boolean overlapping(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }
}
