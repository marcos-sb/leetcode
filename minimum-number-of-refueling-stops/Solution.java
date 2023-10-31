class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) return 0;

        final var N = stations.length;
        final var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        var stops = 0;
        var st = 0;
        var maxDist = startFuel;
        while (maxDist < target) {
            if (st < N && stations[st][0] <= maxDist) {
                maxHeap.offer(stations[st][1]);
                st++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else {
                maxDist += maxHeap.poll();
                stops++;
            }
        }

        return stops;
    }
}
