class Solution {
    public int lengthOfLIS(int[] nums) {
        final var n = nums.length;
        final var tails = new int[n];
        var size = 0;

        for (var num : nums) {
            var lo = 0;
            var hi = size;
            while (lo < hi) {
                final var mid = (hi-lo)/2 + lo;
                if (tails[mid] < num) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = num;
            if (lo == size) ++size;
        }

        return size;
    }
}
