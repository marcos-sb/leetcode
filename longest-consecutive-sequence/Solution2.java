class Solution {
    public int longestConsecutive(int[] nums) {
        final var set = new HashSet<Integer>();
        for (var n : nums) {
            set.add(n);
        }

        var maxLen = 0;
        for (var n : nums) {
            if (!set.remove(n)) {
                continue;
            }

            var len = 1;
            var _n = n;
            while (set.remove(--_n)) {
                ++len;
            }

            _n = n;
            while (set.remove(++_n)) {
                ++len;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
