class Solution {
  public List<int[]> constructOptimalSchedule(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return List.of();
    
    final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[1],b[1]);
    final var res = new ArrayList<int[]>();
    Arrays.sort(intervals, cmp);
    res.add(intervals[0]);
    for (var i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < res.get(res.size()-1)[1]) continue;
      res.add(intervals[i]);
    }

    return res;
  }
}
