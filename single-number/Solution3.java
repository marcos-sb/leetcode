class Solution {

    public int singleNumber(int[] nums) {
        var exor = 0;
        for (var n : nums) {
            exor ^= n;
        }
        return exor;
    }
}
