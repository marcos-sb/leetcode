class Solution {
    public int[] findRightInterval(int[][] intervals) {
        final var lefts2idx = new TreeMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++) {
            lefts2idx.putIfAbsent(intervals[i][0], i);
        }
        
        final var res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            final var entry = lefts2idx.ceilingEntry(intervals[i][1]);
            if (entry == null) res[i] = -1;
            else res[i] = entry.getValue();
        }
        
        return res;
    }
}
