class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final var N = cost.length;
        for (var i = 0; i < N; i++)
            cost[i] = gas[i] - cost[i];
        
        var remSum = 0;
        for (var i = N-1; 0 <= i; i--) {
            remSum += cost[i];
            cost[i] = remSum;
        }
        if (remSum < 0) return -1;
        
        var max = 0;
        var maxI = 0;
        for (var i = 0; i < N; i++) {
            if (max < cost[i]) {
                max = cost[i];
                maxI = i;
            }
        }

        return maxI;
    }
}
