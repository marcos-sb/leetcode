class Solution {
    public int[] singleNumber(int[] nums) {
        var xor = 0;
        for (var n : nums) {
            xor ^= n;
        }

        final var diff = xor & (-xor);
        final var res = new int[2];
        for (var n : nums) {
            if ((diff & n) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }

        return res;
    }
}
