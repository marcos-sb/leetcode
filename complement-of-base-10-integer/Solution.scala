object Solution {
    def bitwiseComplement(N: Int): Int = {
        if (N == 0) return 1
        var _N = N
        var notN = ~N
        var mask = 1
        while (_N > 0) {
            mask = (mask << 1) | 1
            _N >>= 1
        }
        (mask >> 1) & notN
    }
}
