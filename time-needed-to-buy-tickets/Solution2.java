class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        final var n = tickets.length;
        final var queue = new ArrayDeque<int[]>();
        for (var i = 0; i < n; ++i) {
            queue.offer(new int[]{i, tickets[i]});
        }

        var seconds = 0;
        while (!queue.isEmpty()) {
            final var first = queue.poll();
            ++seconds;
            if (0 < --first[1]) {
                queue.offer(first);
            }
            if (first[0] == k && first[1] == 0) {
                break;
            }
        }

        return seconds;
    }
}
