class Solution {
    public int maxEvents(int[][] events) {
        final var n = events.length;
        final var minHeap = new PriorityQueue<Integer>();

        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        var attended = 0;
        var currDay = 1;
        var i = 0;
        while (i < n || !minHeap.isEmpty()) {
            while (i < n && events[i][0] <= currDay) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < currDay) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                ++attended;
            }

            ++currDay;
        }

        return attended;
    }
}
