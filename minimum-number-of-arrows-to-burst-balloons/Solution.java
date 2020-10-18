class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        var arrows = 1;
        var end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                end = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
