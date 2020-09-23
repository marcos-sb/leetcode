class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLeft = gas[0] - cost[0];
        int minLeft = gasLeft;
        int minIdx = 0;
        
        for (int i = 1; i < gas.length; i++) {
            gasLeft += gas[i] - cost[i];
            if (gasLeft < minLeft) {
                minLeft = gasLeft;
                minIdx = i;
            }
        }
        
        if (gasLeft < 0) return -1;
        
        return (minIdx+1) % gas.length;
    }
}
