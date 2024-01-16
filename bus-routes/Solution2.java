class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        final var stop2buses = new HashMap<Integer, List<Integer>>();
        final var B = routes.length;
        for (var bus = 0; bus < B; bus++) // O(B*S)
            for (var stop : routes[bus])  // O(S)
                stop2buses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);

        final var visited = new boolean[B];
        final var q = new ArrayDeque<Integer>(stop2buses.size());
        q.offer(source);
        var buses = 0;
        while (!q.isEmpty()) {
            var levelSize = q.size();
            while (0 < levelSize--) {
                final var currStop = q.poll();
                if (currStop == target) return buses;
                if (!stop2buses.containsKey(currStop)) continue;
                for (var bus : stop2buses.get(currStop)) {
                    if (visited[bus]) continue;
                    for (var stop : routes[bus]) q.offer(stop);
                    visited[bus] = true;
                }
            }
            buses++;
        }

        return -1;
    }
}
