class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        final var stop2buses = new HashMap<Integer, List<Integer>>();
        final var B = routes.length;
        for (var bus = 0; bus < B; bus++) // O(B*S), B: number of buses, S: max stops per bus
            for (var stop : routes[bus])
                stop2buses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);

        final var visitedBus = new boolean[B];
        final var visitedStop = new HashSet<Integer>();
        final var q = new ArrayDeque<Integer>();
        q.offer(source);
        visitedStop.add(source);
        var buses = 0;
        while (!q.isEmpty()) { // O(K), K: all distinct stops
            var levelSize = q.size();
            while (0 < levelSize--) {
                final var currStop = q.poll();
                if (currStop == target) return buses;
                if (!stop2buses.containsKey(currStop)) continue;
                for (var bus : stop2buses.get(currStop)) {
                    if (visitedBus[bus]) continue;
                    for (var stop : routes[bus]) {
                        if (visitedStop.contains(stop)) continue;
                        q.offer(stop);
                        visitedStop.add(stop);
                    }
                    visitedBus[bus] = true;
                }
            }
            buses++;
        }

        return -1;
    }
}
