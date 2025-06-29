class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        final var n = routes.length;
        final var busesByStop = new HashMap<Integer, List<Integer>>();

        for (var i = 0; i < n; ++i) {
            final var route = routes[i];
            for (var stop : route) {
                busesByStop.computeIfAbsent(stop, k -> new ArrayList<>())
                    .add(i);
            }
        }

        final var visitedBus = new HashSet<Integer>();
        final var visitedStop = new HashSet<Integer>();
        final var queue = new ArrayDeque<Integer>();

        if (!busesByStop.containsKey(source) || !busesByStop.containsKey(target))
            return -1;

        for (var bus : busesByStop.get(source)) {
            queue.offer(bus);
            visitedBus.add(bus);
        }
        visitedStop.add(source);

        var buses = 0;
        while (!queue.isEmpty()) {
            var level = queue.size();
            ++buses;
            while (0 < level--) {
                final var currBus = queue.poll();

                for (var stop : routes[currBus]) {
                    if (stop == target) return buses;
                    if (visitedStop.contains(stop)) continue;

                    for (var bus : busesByStop.get(stop)) {
                        if (!visitedBus.add(bus)) continue;
                        queue.offer(bus);
                    }
                    visitedStop.add(stop);
                }
            }
        }

        return -1;
    }
}
