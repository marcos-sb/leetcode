class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 1;
        for (int i = 1; i < n; i++)
            count += dfs(n, i);
        return count;
    }
    
    private static int dfs(int n, int i) {
        if (n-i < 0) return 0;
        if (n-i == 0) return 1;
        return dfs(n-i, i+1);
    }
}
