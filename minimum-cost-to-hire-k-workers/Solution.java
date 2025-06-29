class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        final var n = quality.length;

        final var workers = new Worker[n];
        for (var i = 0; i < n; ++i) {
            workers[i] = new Worker(quality[i], (double) wage[i] / quality[i]);
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a.ratio(), b.ratio()));

        final var maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        var currentQuality = 0;
        var minCost = Double.MAX_VALUE;

        for (var worker : workers) {
            currentQuality += worker.quality();
            maxHeap.offer(worker.quality());

            if (k < maxHeap.size()) {
                currentQuality -= maxHeap.poll();
            }

            if (k == maxHeap.size()) {
                minCost = Math.min(minCost, worker.ratio() * currentQuality);
            }
        }

        return minCost;
    }

    private static record Worker(int quality, double ratio) {}
}
