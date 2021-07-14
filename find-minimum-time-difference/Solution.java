class Solution {
  public int timeDifference(List<String> times) {
    Collections.sort(times);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < times.size(); i++) {
      final String t0 = times.get(i-1);
      final String t1 = times.get(i);
      minDiff = Math.min(minDiff, diff(t0,t1));
    }
    return Math.min(minDiff, diff(times.get(0), times.get(times.size()-1)));
  }

  private static int diff(String t0, String t1) {
    final int t0Mins = toMinutes(t0);
    final int t1Mins = toMinutes(t1);
    final int minDiff = Math.abs(t0Mins - t1Mins);
    return Math.min(24*60 - minDiff, minDiff);
  }

  private static int toMinutes(String t) {
    final String[] hhmm = t.split(":");
    return Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
  }
}
