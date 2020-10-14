class Solution {
    public int bitwiseComplement(int N) {
        if (N > 1)
            return (bitwiseComplement(N >>> 1) << 1) | (N & 1) ^ 1;
        if (N == 1) return 0;
        return 1;
    }
}
