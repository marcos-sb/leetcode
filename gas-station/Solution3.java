class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final var N = cost.length;

        var max = Integer.MIN_VALUE;
        var maxI = 0;
        var leftSum = 0;
        for (var i = N-1; 0 <= i; i--) {
            leftSum += gas[i] - cost[i];
            if (max < leftSum) {
                max = leftSum;
                maxI = i;
            }
        }
        if (leftSum < 0) return -1;
        
        return maxI;
    }
}
