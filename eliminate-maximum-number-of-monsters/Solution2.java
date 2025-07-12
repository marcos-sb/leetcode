class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        final var n = dist.length;
        final var arrival = new int[n];
        for (var i = 0; i < n; ++i) {
            arrival[i] = (dist[i]-1) / speed[i];
        }

        Arrays.sort(arrival);

        var eliminated = 0;
        for (var i = 0; i < n; ++i) {
            if (arrival[i] < i) {
                break;
            }

            ++eliminated;
        }

        return eliminated;
    }
}
