class Solution {
    public int[][] merge(int[][] intervals) {
        final var N = intervals.length;
        final var res = new ArrayList<int[]>();
        
        final Comparator<int[]> cmp = (a,b) -> {
            final var fst = Integer.compare(a[0], b[0]);
            return fst != 0 ? fst : Integer.compare(a[1], b[1]); // this is actually irrelevant bc of :16
        };
        Arrays.sort(intervals, cmp);
        
        res.add(intervals[0]);
        for (var i = 1; i < N; i++) {
            final var l = res.get(res.size()-1);
            final var r = intervals[i];
            if (r[0] <= l[1]) l[1] = Math.max(l[1], r[1]);
            else res.add(r);
        }

        return res.toArray(new int[0][2]);
    }
}
