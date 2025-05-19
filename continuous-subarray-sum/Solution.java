class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        final var n = nums.length;
        final var sums = new HashSet<Integer>();
        var sum = 0;
        var prev = 0;
        for (var num : nums) {
            sum = (sum + num) % k;
            if (sums.contains(sum)) return true;
            sums.add(prev);
            prev = sum;
        }
        return false;
    }
}
