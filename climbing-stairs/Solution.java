class Solution {
    public int climbStairs(int n) {
        return cs(n, new int[]{1,2}, new int[n+1]);
    }
    
    private static int cs(int n, int[] steps, int[] cache) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        
        if (cache[n] != 0) return cache[n];
        
        int ways = 0;
        for (int s : steps) {
            ways += cs(n-s, steps, cache);
        }
        cache[n] = ways;
        
        return ways;
    }
}
