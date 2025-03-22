class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var max = 0;
        for (var i = 0; i < n; ++i) {
            if (informTime[i] == 0) continue;
            max = Math.max(max, dfs(i, manager, informTime));
        }
        return max;
    }

    private static int dfs(int emp, int[] manager, int[] informTime) {
        if (manager[emp] == -1) return informTime[emp];
        informTime[emp] += dfs(manager[emp], manager, informTime);
        manager[emp] = -1;
        return informTime[emp];
    }
}
