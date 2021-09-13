class Solution2 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        final var dims = binaryMatrix.dimensions();
        final var rows = dims.get(0);
        final var cols = dims.get(1);
        
        var r = 0;
        var c = cols-1;
        while (r < rows && 0 < c) {
            while (0 <= c && binaryMatrix.get(r, c) == 1) {
                c--;
            }
            r++;
        }
        return c == cols-1 ? -1 : c+1;
    }
}
