class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var n = points.length;
        final var maxHeap = new PriorityQueue<Pair<Integer, Double>>(
            (a,b) -> Double.compare(b.getValue(), a.getValue())
        );

        for (var i = 0; i < n; ++i) {
            final var point = points[i];
            final var x = point[0];
            final var y = point[1];
            final var dist = Math.sqrt(x*x + y*y);

            maxHeap.offer(new Pair<>(i, dist));

            if (k < maxHeap.size()) {
                maxHeap.poll();
            }
        }

        final var res = new int[k][];
        var i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = points[maxHeap.poll().getKey()];
        }

        return res;
    }
}
