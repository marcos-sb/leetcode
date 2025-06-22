class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var counts = new int[26];
        for (var task : tasks) ++counts[task-'A'];

        final var maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        for (var count : counts) {
            if (count == 0) continue;
            maxHeap.offer(count);
        }

        final var cycle = new ArrayList<Integer>(26);
        var totalCount = 0;
        var i = 0;
        while (!maxHeap.isEmpty()) {
            i = 0;
            while (i < n+1) {
                if (maxHeap.isEmpty()) break;
                final var count = maxHeap.poll();
                if (1 < count) cycle.add(count-1);
                ++i;
            }
            totalCount += n+1;

            maxHeap.addAll(cycle);
            cycle.clear();
        }

        return totalCount - (n+1) + i; // full cycles + the last partial cycle
    }
}
