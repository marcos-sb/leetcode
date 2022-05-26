class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        final var aux = new ArrayList<int[]>();
        aux.add(intervals[0]);
        var last = intervals[0];
        for (var i = 1; i < intervals.length; i++) {
            final var cur = intervals[i];
            last = aux.get(aux.size()-1);
            if (cur[0] <= last[1]) last[1] = Math.max(last[1], cur[1]);
            else aux.add(cur);
        }
        
        final var res = new int[aux.size()][];
        for (var i = 0; i < res.length; i++)
            res[i] = aux.get(i);
        return res;
    }
}
