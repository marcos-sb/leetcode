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

        final var visited = new HashSet<Integer>();
        final var queue = new ArrayDeque<Integer>();

        if (!busesByStop.containsKey(source) || !busesByStop.containsKey(target))
            return -1;

        for (var bus : busesByStop.get(source)) {
            queue.offer(bus);
            visited.add(bus);
        }

        var buses = 0;
        while (!queue.isEmpty()) {
            var level = queue.size();
            ++buses;
            while (0 < level--) {
                final var currBus = queue.poll();

                for (var stop : routes[currBus]) {
                    if (stop == target) return buses;

                    for (var bus : busesByStop.get(stop)) {
                        if (!visited.add(bus)) continue;
                        queue.offer(bus);
                    }
                }
            }
        }

        return -1;
    }
}
