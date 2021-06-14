class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[1],b[1]);
    Arrays.sort(intervals, cmp);
    var lastEnd = intervals[0][1];
    var count = 1;
    for (var i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < lastEnd) continue;
      lastEnd = intervals[i][1];
      count++;
    }
    return intervals.length - count;
  }
}
