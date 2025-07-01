class Solution {
    public int lastStoneWeightII(int[] stones) {
        var sum = 0;
        for (var stone : stones)
            sum += stone;

        final var target = sum/2;
        final var dp = new boolean[target+1];
        dp[0] = true;

        for (var stone : stones) {
            for (var j = target; stone <= j; --j) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        var maxSum = 0;
        for (var i = target; 0 <= i; --i) {
            if (dp[i]) {
                maxSum = i;
                break;
            }
        }

        return sum - 2 * maxSum;
    }
}
