class Solution {
    public int[][] merge(int[][] invals) {
        final var n = invals.length;

        Arrays.sort(invals, (a,b) -> a[0] - b[0]);

        var k = 0;
        for (var i = 1; i < n; ++i) {
            if (invals[i][0] <= invals[k][1]) {
                invals[k][1] = Math.max(invals[k][1], invals[i][1]);
            } else {
                ++k;
                invals[k] = invals[i];
            }
        }

        return Arrays.copyOf(invals, k+1);
    }
}
