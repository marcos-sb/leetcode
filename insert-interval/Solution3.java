class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final var N = intervals.length;
        final var res = new ArrayList<int[]>();
        
        final Comparator<int[]> cmp = (a,b) -> {
            final var _cmp = Integer.compare(a[0], b[0]);
            return _cmp == 0 ? Integer.compare(a[1], b[1]) : _cmp;
        };
        var ii = Arrays.binarySearch(intervals, newInterval, cmp);
        if (0 <= ii) return intervals; // newinterval is already present
        
        ii = (ii + 1) * -1;
        if (0 < ii) {
            for (var i = 0; i < ii; i++) res.add(intervals[i]);
            final var l = res.get(res.size()-1);
            if (newInterval[0] <= l[1]) l[1] = Math.max(newInterval[1], l[1]);
            else res.add(newInterval);
        } else res.add(newInterval);
        
        for (var i = ii; i < N; i++) {
            final var l = res.get(res.size()-1);
            final var r = intervals[i];
            if (r[0] <= l[1]) l[1] = Math.max(l[1], r[1]);
            else res.add(r);
        }

        return res.toArray(new int[0][2]);
    }
}
