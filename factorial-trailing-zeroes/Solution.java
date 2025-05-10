class Solution {
    public int trailingZeroes(int n) {
        var count = 0;
        while (0 < n) {
            count += n /= 5;
        }
        return count;
    }
}
