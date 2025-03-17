class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        var count = 1;
        var curr = 0;
        for (var i = 1; i < points.length; i++) {
            if (points[curr][1] < points[i][0]) {
                ++count;
                curr = i;
            }
        }
        return count;
    }
}
