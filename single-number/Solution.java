class Solution {
    public int singleNumber(int[] nums) {
        var unique = 0;
        for (var n : nums) unique ^= n;
        return unique;
    }
}
