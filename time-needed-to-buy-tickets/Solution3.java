class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        final var n = tickets.length;
        final var target = tickets[k];

        var time = 0;
        for (var i = 0; i < n; ++i) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target-1);
            }
        }

        return time;
    }
}
