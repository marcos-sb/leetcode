class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var n : nums) sum += n;
        if (sum % 2 == 1) return false; // sum div 2 <=> can bipartite

        final var N = nums.length;
        final var dp = new boolean[sum/2 + 1];
        dp[0] = true; // You can always find a subset with no elements adding up to 0
        
        // This problem is tricky. This solution is an space-compact variant of the
        // 'traditional' bottom-up (tabular) DP solution. In that non-compact version
        // we have rows for elements that we're considering, and columns until sum/2.
        // We only consider until sum/2 because we're only going to be adding elements
        // to one subset, and assume both subsets will have half of the sum. This
        // holds as required in line 5.
        //
        // Again, in that non-compact solution we iterate row-wise. On each cell, we will
        // consider if the current element can be added to a subset whose sum would
        // equal the current col, 'c'. We have, then, two possible options: either we
        // include the element in the subset or not.
        //
        // We can only include the element if it's smaller than the current subset sum, 'c'.
        // This is the condition we check in that nested 'if'. If it's bigger, we have to copy
        // the value of the row above the current one, meaning: "we can form a subset
        // adding up to 'c' if we could when we didn't consider the current element".
        //
        // If the element is smaller than 'c', we can either include it or not. Including it
        // means: "we can form a subset summing 'c' including the current element if we could
        // form a subset when we didn't consider it (the row above) and the sum of that subset was
        // 'c' - the element (c - nums[r-1]).
        //
        // final var N = nums.length;
        // final var dp = new boolean[N+1][sum/2 + 1];
        // for (var r = 0; r <= N; r++) dp[r][0] = true;
        // for (var r = 1; r <= N; r++) {
        //     for (var c = 1; c <= sum/2; c++) {
        //         dp[r][c] = dp[r-1][c];
        //         if (0 <= c - nums[r-1])
        //             dp[r][c] |= dp[r-1][c-nums[r-1]];
        //     }
        // }
        //
        // Now, if you actually fill up that 2D DP table, you'll see that once a cell is
        // true, it never flips back to false. So a compact version of this simply checks
        // whether including the current element ('r' in the solution below) would make
        // the subset sum up to 'c'. That's because not including the element (row above in
        // the non-compact solution) is already in place in this compact solution, so there's
        // no need to copy it from the row above, and so, no need to have more than one row.
        // There's a trick though. In order to prevent the solution from overwriting the
        // values in the single row, we have to iterate the table backwards.
        //
        for (var r = 0; r < N; r++) {
            for (var c = sum/2; 0 <= c; c--) {
                if (0 <= c - nums[r]) dp[c] |= dp[c-nums[r]];
            }
        }

        return dp[sum/2];
    }
}
