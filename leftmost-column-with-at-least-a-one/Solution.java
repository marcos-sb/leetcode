class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        final var dims = binaryMatrix.dimensions();
        final var rows = dims.get(0);
        final var cols = dims.get(1);
        
        var minHi = cols-1;
        var r = 0;
        var foundOne = false;
        while (r < rows && 0 < minHi) {
            var lo = 0;
            var hi = minHi;
            while (lo < hi) {
                final var mid = (hi-lo)/2 + lo;
                if (binaryMatrix.get(r, mid) == 0) lo = mid+1;
                else {
                    foundOne = true;
                    hi = mid;
                }
            }
            if (!foundOne && binaryMatrix.get(r, hi) == 1) foundOne = true;
            minHi = Math.min(minHi, hi);
            r++;
        }
        
        return minHi < cols-1 || foundOne ? minHi : -1;
    }
}
