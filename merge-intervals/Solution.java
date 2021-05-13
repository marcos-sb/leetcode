/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        
        final Comparator<Interval> cmp = (i1,i2) -> Integer.compare(i1.start, i2.start);
        Collections.sort(intervals, cmp);

        final List<Interval> res = new ArrayList<>();
        Interval merged = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            final Interval ii = intervals.get(i);
            if (overlapping(merged, ii)) {
                merged = merge(merged, ii);
            } else {
                res.add(merged);
                merged = ii;
            }
        }
        res.add(merged);

        return res;
    }

    private static boolean overlapping(Interval i1, Interval i2) {
        return i2.start <= i1.end;
    }
    
    private static Interval merge(Interval i1, Interval i2) {
        i1.end = Math.max(i1.end, i2.end);
        return i1;
    }
}
