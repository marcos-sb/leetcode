class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] arr) -> arr[0]));
        var j = 0;
        var nonOverlapping = 1;
        for (int i = 1; i < intervals.length; i++) {
            final var inti = intervals[i];
            final var intj = intervals[j];
            if (intj[0] <= inti[0] && inti[1] <= intj[1]) // j covers i
                continue;
            else if (!(inti[0] <= intj[0] && intj[1] <= inti[1])) // i doesn't cover j
                nonOverlapping++;
            j = i;
        }
        return nonOverlapping;
    }
}
