class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var min = Integer.MAX_VALUE;
        var station = -1;
        var runningSum = 0;
        for (var i = 0; i < gas.length; ++i) {
            final var diff = gas[i] - cost[i];
            runningSum += diff;
            if (runningSum < min) {
                min = runningSum;
                station = i;
            }
        }

        station = (station + 1) % gas.length;

        return runningSum < 0 ? -1 : station;
    }
}
