class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        final Map<Integer, List<Integer>> stop2buses = new HashMap<>();
        final var N = routes.length;
        for (var i = 0; i < N; i++) {
            final var M = routes[i].length;
            for (var j = 0; j < M; j++)
                stop2buses.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
        }

        var buses = 0;
        final var seenStops = new HashSet<Integer>();
        final var seenBuses = new HashSet<Integer>();
        final var q = new LinkedList<Integer>();
        q.offer(source);
        seenStops.add(source);
        while (!q.isEmpty()) {
            var size = q.size();
            while (size-- > 0) {
                final var curStop = q.poll();
                if (curStop == target) return buses;
                
                for (var bus : stop2buses.getOrDefault(curStop, List.of())) {
                    if (seenBuses.contains(bus)) continue;
                    seenBuses.add(bus);
                    for (var stop : routes[bus]) {
                        if (seenStops.contains(stop)) continue;
                        q.offer(stop);
                        seenStops.add(stop);
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}
