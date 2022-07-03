class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        final var N = nums.length;
        if (N < 3) return 0;
        
        var total = 0;
        var matchLength = 3;
        var prev = nums[1]-nums[0];
        var curr = 0;
        for (var i = 2; i < N; i++) {
            curr = nums[i]-nums[i-1];
            if (prev == curr) {
                total += matchLength-3+1;
                matchLength++;
            } else matchLength = 3;
            prev = curr;
        }
        
        return total;
    }
}
