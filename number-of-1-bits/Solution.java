public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        int _n = n;
        while (_n != 0) {
            ones += _n & 1;
            _n >>>= 1;
        }
        return ones;
    }
}
