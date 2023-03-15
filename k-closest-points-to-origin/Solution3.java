class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final Comparator<int[]> cmp = (a, b) -> Integer.compare(distance(a), distance(b));
        Arrays.sort(points, cmp);
        final var N = points.length;
        if (N <= k) return points;
        return Arrays.copyOfRange(points, 0, k);
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
